package com.example.projektbackend.DTO;


import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class UserDTO {

    private String username;
    private String password;
    @Email
    private String email;

}
