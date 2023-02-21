package com.example.projektbackend.DTO.flashcardset;

import com.example.projektbackend.model.Flashcard;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class FlashcardSetGetDTO {

    private UUID id;
    private String name;
    private String description;
    private List<Flashcard> flashcardsDTO;
}
