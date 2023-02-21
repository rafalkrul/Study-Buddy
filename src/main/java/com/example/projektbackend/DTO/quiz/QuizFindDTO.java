package com.example.projektbackend.DTO.quiz;


import lombok.Data;


import java.util.UUID;

@Data
public class QuizFindDTO {

    private UUID category_id;

    private UUID level_id;

    private UUID unit_id;


}
