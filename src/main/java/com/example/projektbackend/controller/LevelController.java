package com.example.projektbackend.controller;

import com.example.projektbackend.DTO.level.LevelDTO;
import com.example.projektbackend.DTO.user.UserDTO;
import com.example.projektbackend.service.level.LevelService;
import com.example.projektbackend.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LevelController {

    private final LevelService levelService;

    @PostMapping("/level")
    public ResponseEntity<UUID> addLevel(@RequestBody LevelDTO level) {
        var level_id = levelService.CreateLevel(level);
        return new ResponseEntity<>(level_id, HttpStatus.CREATED);
    }

}
