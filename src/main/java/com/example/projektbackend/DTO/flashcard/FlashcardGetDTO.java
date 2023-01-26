package com.example.projektbackend.DTO.flashcard;

import lombok.Data;

import java.util.UUID;

@Data
public class FlashcardGetDTO {

    private UUID id;
    private String word;
    private String translation;

}
