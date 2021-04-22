package com.project.apigateway.authentication.controller;

import ch.qos.logback.core.subst.Token;
import com.project.apigateway.authentication.config.JwtTokenUtil;
import com.project.apigateway.authentication.model.User;
import com.project.apigateway.authentication.model.UserAtLogin;
import com.project.apigateway.authentication.model.UserForLoginState;
import com.project.apigateway.authentication.model.UserWithPassword;
import com.project.apigateway.authentication.service.UserService;
import com.project.sportsgeeksystemresponse.response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users",produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    UserService userService;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @GetMapping
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Result<List<User>>> getAllUsers() {
        Result<List<User>> userList = userService.findAllUsers();
        return new ResponseEntity<>(userList, HttpStatus.valueOf(userList.getCode()));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('Admin','User')")
    public ResponseEntity<Result<User>> getUserById(@PathVariable int id) throws Exception {
        Result<User> userResult = userService.findUserByUserId(id);
        return new ResponseEntity<>(userResult, HttpStatus.valueOf(userResult.getCode()));
    }
    @PostMapping("/authenticate-status")
    @PreAuthorize("hasAnyRole('Admin','User')")
    public ResponseEntity<Result<UserForLoginState>> authenticateStatus(@RequestBody(required = true) UserAtLogin userAtLogin) throws  Exception {
        Result<UserForLoginState> userResult = userService.authenticateStatus(userAtLogin);
        System.out.println("UserResult "+userResult);
        return new ResponseEntity(userResult, HttpStatus.valueOf(userResult.getCode()));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<Result<Token>> authenticate(@RequestBody(required = true) UserAtLogin userAtLogin) throws  Exception {
        System.out.println(" Rest Authenticate");
        authenticate(userAtLogin.getUsername(), userAtLogin.getPassword());
        final UserDetails userDetails = userService.loadUserByUsername(userAtLogin.getUsername());
        System.out.println("User Details"+userDetails);
        final String token = jwtTokenUtil.generateToken(userDetails);
        System.out.println("UserToken"+token);
        return new ResponseEntity("{\"token\":\"" + token + "\"}",HttpStatus.valueOf(200));
    }
    private void authenticate(String username, String password) throws Exception {
        try {
            System.out.println("Authenticate method");
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            System.out.println("AUthenticate called");
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
