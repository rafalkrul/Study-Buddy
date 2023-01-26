package com.example.projektbackend.DTO.user;

import lombok.Data;

import java.util.UUID;

@Data
public class UserEditDTO {

    private UUID user_id;

    private String password;

    private String email;


}
