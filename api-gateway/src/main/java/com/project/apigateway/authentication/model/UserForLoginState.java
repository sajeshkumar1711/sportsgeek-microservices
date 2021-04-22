package com.project.apigateway.authentication.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserForLoginState {

	private int UserId;
    private String Username;
    private String Role;
    private boolean Status;
}
