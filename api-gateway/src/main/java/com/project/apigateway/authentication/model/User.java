package com.project.apigateway.authentication.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.project.queryhelpher.annotations.QueryHelperPrimaryKey;
import lombok.*;

import javax.validation.constraints.NotNull;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class User {
	
    @QueryHelperPrimaryKey
    private int UserId;
    @NotNull
    private String FirstName;
    @NotNull
    private String LastName;
    @NotNull
    private int GenderId;
    @NotNull
    private String Username;
    private String ProfilePicture;
    private String Email;
    private String MobileNumber;
    @NotNull
    private int RoleId;
    private  int AvailablePoints;
    private boolean status;
    
    public User(UserWithPassword userWithPassword) {
        super();
            UserId = userWithPassword.getUserId();
            FirstName = userWithPassword.getFirstName();
            LastName = userWithPassword.getLastName();
            GenderId = userWithPassword.getGenderId();
            Username = userWithPassword.getUsername();
            ProfilePicture = userWithPassword.getProfilePicture();
            RoleId = userWithPassword.getRoleId();
            AvailablePoints = userWithPassword.getAvailablePoints();
            status = userWithPassword.isStatus();
        }

}
