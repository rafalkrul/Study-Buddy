package com.example.projektbackend.controller;

import com.example.projektbackend.DTO.user.UserDTO;
import com.example.projektbackend.DTO.user.UserEditDTO;
import com.example.projektbackend.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
        userService.DeleteUserById(user_id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getUsers(){
        var users = userService.GetAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/users/{user_id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable UUID user_id){
       var user = userService.GetUserById(user_id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/usersByUsername/{userUsername}")
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String userUsername){
        var user = userService.GetUserByUsername(userUsername);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PostMapping("/user/edit")
    public ResponseEntity<Void> EditUserData(@RequestBody UserEditDTO userEditDTO){
        userService.EditUserData(userEditDTO);
        return ResponseEntity.ok().build();
    }
}
