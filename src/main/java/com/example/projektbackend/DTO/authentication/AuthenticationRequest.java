package com.example.projektbackend.DTO.authentication;


import lombok.Data;


@Data
public class AuthenticationRequest {

    private String username;
    private String password;

}
