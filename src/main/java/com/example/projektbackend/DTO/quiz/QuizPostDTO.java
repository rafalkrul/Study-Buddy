package com.example.projektbackend.DTO.quiz;

import com.example.projektbackend.DTO.question.QuestionDTO;
import lombok.Data;

import java.util.List;

@Data
public class QuizPostDTO {

   private QuizDTO quizDTO;

   private List<QuestionDTO> questionsDTO;
}
