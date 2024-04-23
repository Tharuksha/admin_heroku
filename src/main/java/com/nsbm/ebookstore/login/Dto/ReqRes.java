package com.nsbm.ebookstore.login.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.nsbm.ebookstore.login.Entity.Users;
import lombok.Data;

@Data@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReqRes {
    private int statusCode;
    private long userid;
    private String error;
    private String message;
    private String token;
    private String refreshToken;
    private String expirationTime;
    private String firstname;
    private String lastname;
    private String email;
    private String role;
    private String password;
    private Users users;
}
