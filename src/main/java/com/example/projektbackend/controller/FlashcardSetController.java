package com.example.projektbackend.controller;

import com.example.projektbackend.DTO.flashcardset.FlashcardSetPostDTO;
import com.example.projektbackend.service.flashcardset.FlashcardSetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class FlashcardSetController {

    private final FlashcardSetService flashCardSetService;


    @PostMapping("/flashcardset")
    public ResponseEntity<UUID> CreateFlashcardSet(@RequestBody FlashcardSetPostDTO flashCardSetPostDTO){
        var flashcardset_id = flashCardSetService.CreateFlashCardSet(flashCardSetPostDTO);
        return new ResponseEntity<>(flashcardset_id, HttpStatus.CREATED);
    }

}
