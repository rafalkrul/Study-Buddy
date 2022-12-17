package com.example.projektbackend.DTO.quiz;

import com.example.projektbackend.model.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class QuizDTO {


    private Category category;

    private Level level;

    private User user;

    private Unit unit;
    private String title;

    private String description;
    private List<Question> questions;

}
