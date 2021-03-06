package com.project.apigateway.authentication.mapper;

import com.project.apigateway.authentication.model.UserWithPassword;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserWithPasswordRowMapper implements RowMapper<UserWithPassword>{

	@Override
	public UserWithPassword mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserWithPassword userWithPassword = new UserWithPassword();
        userWithPassword.setUsername(rs.getString("UserName"));
        userWithPassword.setPassword(rs.getString("Password"));
        userWithPassword.setRole(rs.getString("Name"));
        return userWithPassword;
	}

}
