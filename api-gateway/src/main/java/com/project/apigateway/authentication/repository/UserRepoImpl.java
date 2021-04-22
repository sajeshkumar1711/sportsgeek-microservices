package com.project.apigateway.authentication.repository;

import com.project.apigateway.authentication.mapper.UserRowMapper;
import com.project.apigateway.authentication.mapper.UserWithPasswordRowMapper;
import com.project.apigateway.authentication.model.User;
import com.project.apigateway.authentication.model.UserAtLogin;
import com.project.apigateway.authentication.model.UserForLoginState;
import com.project.apigateway.authentication.model.UserWithPassword;
import com.project.queryhelpher.QueryGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository(value = "userRepo")
public class UserRepoImpl implements UserRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	private QueryGenerator<UserWithPassword> queryGenerator = new QueryGenerator<UserWithPassword>();
	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		
	@Override
	public List<User> findAllUsers() {
		String sql = "SELECT User.UserId as UserId, FirstName, LastName, GenderId, RoleId, Username, AvailablePoints, ProfilePicture, Status, EmailContact.EmailId as Email, MobileContact.MobileNumber as MobileNumber " +
				"FROM User inner join EmailContact on User.UserId=EmailContact.UserID inner join MobileContact on User.UserId=MobileContact.UserId WHERE User.Status=1 ";
		return jdbcTemplate.query(sql,new UserRowMapper());
	}

	@Override
	public List<User> findUserByUserId(int id) throws Exception {
		String sql = "SELECT User.UserId as UserId, FirstName, LastName, GenderId, RoleId, Username, AvailablePoints, ProfilePicture, Status, EmailContact.EmailId as Email, MobileContact.MobileNumber as MobileNumber " +
                "FROM User inner join EmailContact on User.UserId=EmailContact.UserId inner join MobileContact on User.UserId=MobileContact.UserId WHERE User.UserId="+id;
		return jdbcTemplate.query(sql, new UserRowMapper());
	}

	@Override
	public List<UserWithPassword> findUserByUserName(String userName) throws Exception {
		String sql = "SELECT u.UserName as UserName,u.Password as Password,r.Name as Name FROM User as u INNER JOIN Role as r on u.RoleId=r.RoleId WHERE UserName='"+userName+"'";
	    return jdbcTemplate.query(sql,new UserWithPasswordRowMapper());
	}


	@Override
	public UserForLoginState authenticate(UserAtLogin userAtLogin) throws Exception {
		 String sql = "select `UserId`,`UserName`, `Name` as `Role`,`Status` from User inner join Role on User.RoleId = Role.RoleId where `UserName`=:username";

       List<Map<String, Object>> list = jdbcTemplate.queryForList(sql,
               new BeanPropertySqlParameterSource(userAtLogin));
       System.out.println(list.size());
       if (list.size() > 0) {

               return new UserForLoginState(Integer.parseInt(list.get(0).get("UserId") + ""),
                       list.get(0).get("UserName") + "", list.get(0).get("Role") + "", Boolean.parseBoolean(list.get(0).get("Status").toString()));

       }
       return null;
	}
}
