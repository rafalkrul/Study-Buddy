package com.example.projektbackend.DTO.question;

import com.example.projektbackend.DTO.singleanswer.SingleAnswerDTO;
import lombok.Data;

import java.util.List;

@Data
public class QuestionDTO {
    private String question;

    private List<SingleAnswerDTO> answerListDTO;
}
