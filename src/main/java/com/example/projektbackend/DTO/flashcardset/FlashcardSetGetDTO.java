package com.example.projektbackend.DTO.flashcardset;

import com.example.projektbackend.DTO.flashcard.FlashcardDTO;
import com.example.projektbackend.model.Flashcard;
import lombok.Data;

import java.util.List;

@Data
public class FlashcardSetGetDTO {

    private String name;

    private String description;
    private List<Flashcard> flashcardsDTO;
}
