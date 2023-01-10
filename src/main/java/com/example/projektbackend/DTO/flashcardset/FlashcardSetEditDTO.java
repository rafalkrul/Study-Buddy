package com.example.projektbackend.DTO.flashcardset;

import com.example.projektbackend.model.Flashcard;
import lombok.Data;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Data
public class FlashcardSetEditDTO {

    private UUID flashcardset_id;
    private String name;
    private String description;
    private List<Flashcard> flashcards;
}
