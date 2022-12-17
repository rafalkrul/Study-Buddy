package com.example.projektbackend.controller;

import com.example.projektbackend.DTO.quiz.QuizPostDTO;
import com.example.projektbackend.service.quiz.QuizService;
import jakarta.validation.Valid;
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
public class QuizController {


    private final QuizService quizService;

    @PostMapping("/quiz")
    public ResponseEntity<UUID> CreateQuiz(@Valid @RequestBody QuizPostDTO quizPostDTO) {
        var quiz_id = quizService.CreateQuiz(quizPostDTO);
        return new ResponseEntity<>(quiz_id, HttpStatus.CREATED);
    }

//    @PostMapping("/quiz")
//    public ResponseEntity<UUID> CreateQuiz(@RequestBody QuizDTO quizDTO, @RequestBody List<Question> questionList) {
//        UUID quiz_id = quizService.CreateQuiz(quizDTO, questionList);
//        return new ResponseEntity<>(quiz_id, HttpStatus.CREATED);
//    }

}
