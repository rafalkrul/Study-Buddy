package com.example.projektbackend.DTO.quiz;

import com.example.projektbackend.model.*;
import lombok.Data;

import java.util.List;

@Data
public class QuizGetDTO {


    private String title;

    private String description;

    private List<Question> questions;
}
