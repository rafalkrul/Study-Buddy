package com.example.projektbackend.DTO.user;

import jakarta.validation.constraints.Email;
import lombok.Data;

import java.util.UUID;

@Data
public class UserEditDTO {

    private UUID user_id;

    private String password;
    @Email
    private String email;


}
