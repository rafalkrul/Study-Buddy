package com.example.projektbackend.DTO.flashcardset;

import com.example.projektbackend.DTO.flashcard.FlashcardDTO;
import lombok.Data;

import java.util.List;

@Data
public class FlashcardSetPostDTO {

    private FlashcardSetDTO flashcardSetDTO;

    private List<FlashcardDTO> flashcardsDTO;
}
