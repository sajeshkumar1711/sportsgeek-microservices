package com.project.apigateway.authentication.service;

import com.project.apigateway.authentication.model.User;
import com.project.apigateway.authentication.model.UserAtLogin;
import com.project.apigateway.authentication.model.UserForLoginState;
import com.project.apigateway.authentication.model.UserWithPassword;
import com.project.apigateway.authentication.repository.UserRepository;
import com.project.sportsgeeksystemresponse.exception.ResultException;
import com.project.sportsgeeksystemresponse.response.Result;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    public Result<List<User>> findAllUsers() {
        List<User> userList = userRepository.findAllUsers();
        return new Result<>(200,userList);
    }

    public Result<User> findUserByUserId(int id) throws Exception {
        List<User> userList = userRepository.findUserByUserId(id);
        if (userList.size() > 0) {
            return new Result<>(200, userList.get(0));
        }
        else {
            throw new ResultException(new Result<>(404, "no user's found, please try again!",
                    new ArrayList<>(Arrays.asList(new Result.SportsGeekSystemError((id + "").hashCode(),
                            "user with given id('" + id + "') does not exists")))));
        }
    }

    public Result<UserForLoginState> authenticateStatus(UserAtLogin userAtLogin) throws Exception {
        UserForLoginState userForLoginState =userRepository.authenticate(userAtLogin);
        System.out.println("UserForLoginState:"+userForLoginState);
        if (userForLoginState != null) {
            if (userForLoginState.isStatus() == false) {
                return new Result<>(401, "Sorry! you have been blocked by the admin");
            } else {
                return new Result<>(200, userForLoginState);
            }
        }

        return new Result<>(400, "Invalid username or password!");
    }

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<UserWithPassword> userList = userRepository.findUserByUserName(s);
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_"+userList.get(0).getRole()));
        if (userList == null) {
            throw new UsernameNotFoundException("User not found with username: " + s);
        }
        else {
            return new org.springframework.security.core.userdetails.User(userList.get(0).getUsername(),userList.get(0).getPassword(),
                    authorities);
        }
    }
}
