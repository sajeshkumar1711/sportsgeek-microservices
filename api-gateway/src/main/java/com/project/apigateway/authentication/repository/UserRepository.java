package com.project.apigateway.authentication.repository;

import com.project.apigateway.authentication.model.User;
import com.project.apigateway.authentication.model.UserAtLogin;
import com.project.apigateway.authentication.model.UserForLoginState;
import com.project.apigateway.authentication.model.UserWithPassword;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "userRepo")
public interface UserRepository {
	
    public List<User> findAllUsers();
    public List<User> findUserByUserId(int id) throws Exception;
    public List<UserWithPassword> findUserByUserName(String userName) throws Exception;
    public UserForLoginState authenticate(UserAtLogin userAtLogin) throws Exception;
}
