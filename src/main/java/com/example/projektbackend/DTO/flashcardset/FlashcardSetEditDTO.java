package com.example.projektbackend.DTO.flashcardset;

import com.example.projektbackend.DTO.flashcard.FlashcardDTO;
import lombok.Data;


import java.util.List;
import java.util.UUID;

@Data
public class FlashcardSetEditDTO {

    private UUID id;
    private String name;
    private String description;
    private List<FlashcardDTO> flashcardsDTO;
}
