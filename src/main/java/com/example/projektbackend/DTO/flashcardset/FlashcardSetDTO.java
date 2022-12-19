package com.example.projektbackend.DTO.flashcardset;

import com.example.projektbackend.model.Flashcard;
import com.example.projektbackend.model.Level;
import com.example.projektbackend.model.User;
import lombok.Data;

import java.util.List;

@Data
public class FlashcardSetDTO {

    private Level level;

    private User user;

    private String name;

    private String description;

    private List<Flashcard> flashcards;
}
