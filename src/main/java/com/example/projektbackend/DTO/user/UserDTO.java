package com.example.projektbackend.DTO.user;


import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class UserDTO {

    private String username;
    private String password;
    @Email
    private String email;

}
