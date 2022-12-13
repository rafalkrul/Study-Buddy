package com.example.projektbackend.controller;

import com.example.projektbackend.DTO.QuestionDTO;
import com.example.projektbackend.service.question.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping("/question")
    public ResponseEntity<UUID> CreateQuestion(@RequestBody QuestionDTO question) {
        var question_id = questionService.CreateQuestion(question);
        return new ResponseEntity<>(question_id, HttpStatus.CREATED);
    }

    @DeleteMapping("/question/{question_id}")
    public ResponseEntity<Void> deleteQuestionById(@PathVariable UUID question_id){
        questionService.deleteQuestionById(question_id);
        return ResponseEntity.ok().build();
    }
}
