package com.example.projektbackend.controller;

import com.example.projektbackend.DTO.quiz.*;
import com.example.projektbackend.model.*;
import com.example.projektbackend.repository.QuizRepository;
import com.example.projektbackend.service.quiz.QuizService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class QuizController {


    private final QuizService quizService;
    private final QuizRepository quizRepository;

    private final ModelMapper mapper;

    @PostMapping("/add_quiz")
    public ResponseEntity<UUID> CreateQuiz(@RequestBody QuizPostDTO quizPostDTO) {
        var quiz_id = quizService.CreateQuiz(quizPostDTO);
        return new ResponseEntity<>(quiz_id, HttpStatus.CREATED);
    }

    @PostMapping("/quiz/edit")
    public ResponseEntity<Void> EditQuiz(@RequestBody QuizEditDTO quizEditDTO){
        quizService.EditQuizData(quizEditDTO);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/quiz/addquestion")
        public ResponseEntity<Void> AddQuestionToQuiz(@RequestBody QuizEditDTO quizEditDTO ){
        quizService.AddQuestionToQuiz(quizEditDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/quiz/{quiz_id}")
        public ResponseEntity<QuizGetDTO> GetQuizById(@PathVariable UUID quiz_id) {
       var quiz = quizService.GetQuizById(quiz_id);
        return new ResponseEntity<>(quiz,HttpStatus.OK);
    }

    @GetMapping("/quiz")
    public ResponseEntity<Quiz> getQuiz (@RequestBody QuizFindDTO quizFindDTO){
        var quiz = quizService.findByCategoryIdAndLevelIdAndUnitId(quizFindDTO.getCategory_id(),quizFindDTO.getLevel_id(),quizFindDTO.getUnit_id());
        return new ResponseEntity<>(quiz, HttpStatus.OK);
    }
}
