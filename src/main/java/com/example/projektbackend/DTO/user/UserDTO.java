package com.example.projektbackend.DTO.user;

import lombok.Data;

@Data
public class UserDTO {

    private String username;
    private String password;

    private String email;

   private String role;

}
