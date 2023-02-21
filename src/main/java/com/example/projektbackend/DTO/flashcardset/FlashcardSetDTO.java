package com.example.projektbackend.DTO.flashcardset;

import com.example.projektbackend.model.User;
import lombok.Data;

@Data
public class FlashcardSetDTO {

    private User user;

    private String name;

    private String description;

}
