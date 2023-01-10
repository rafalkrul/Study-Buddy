package com.example.projektbackend.DTO.quiz;

import com.example.projektbackend.model.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class QuizFindDTO {

    private UUID category_id;

    private UUID level_id;

    private UUID unit_id;


}
