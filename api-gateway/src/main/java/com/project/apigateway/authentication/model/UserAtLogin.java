package com.project.apigateway.authentication.model;

import lombok.*;

import javax.validation.constraints.NotNull;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserAtLogin {

	@NotNull
    private String Username;
    @NotNull
    private String Password;
}
