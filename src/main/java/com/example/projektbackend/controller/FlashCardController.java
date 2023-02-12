package com.example.projektbackend.controller;


import com.example.projektbackend.DTO.flashcard.FlashcardDTO;
import com.example.projektbackend.service.flashcard.FlashcardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class FlashCardController {

    private final FlashcardService flashcardService;

    @PostMapping("/flashcard")
    public ResponseEntity<UUID> CreateFlashcard(@RequestBody FlashcardDTO flashcardDTO){
        var flashcard_id = flashcardService.CreateFlashcard(flashcardDTO);
        return new ResponseEntity<>(flashcard_id, HttpStatus.CREATED);
    }

    @DeleteMapping("/flashcardDelete/{flashcardId}")
    ResponseEntity<Void> deleteFlashcardsetbyId(@PathVariable UUID flashcardId){
        flashcardService.deleteFlashcardById(flashcardId);
        return ResponseEntity.ok().build();
    }

}
