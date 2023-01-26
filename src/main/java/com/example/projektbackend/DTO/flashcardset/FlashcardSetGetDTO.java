package com.example.projektbackend.DTO.flashcardset;

import com.example.projektbackend.DTO.flashcard.FlashcardDTO;
import lombok.Data;

import java.util.List;

@Data
public class FlashcardSetGetDTO {

    private String name;

    private String description;
    private List<FlashcardDTO> flashcardsDTO;
}
