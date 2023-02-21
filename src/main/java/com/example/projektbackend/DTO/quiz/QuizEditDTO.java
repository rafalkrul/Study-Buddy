package com.example.projektbackend.DTO.quiz;

import com.example.projektbackend.DTO.question.QuestionDTO;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class QuizEditDTO {

    private UUID id;
    private String title;

    private String description;

    private List<QuestionDTO> questionsDTO;

}
