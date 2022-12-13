package com.example.projektbackend.controller;

import com.example.projektbackend.DTO.UserDTO;
import com.example.projektbackend.model.User;
import com.example.projektbackend.repository.UserRepository;
import com.example.projektbackend.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public ResponseEntity<UUID> addUser(@RequestBody UserDTO user) {
        var user_id = userService.CreateUser(user);
        return new ResponseEntity<>(user_id, HttpStatus.CREATED);
    }

    @DeleteMapping("/user/{user_id}")
    public ResponseEntity<Void> deleteUserbyId(@PathVariable UUID user_id){
        userService.deleteUserById(user_id);
        return ResponseEntity.ok().build();
    }
}
