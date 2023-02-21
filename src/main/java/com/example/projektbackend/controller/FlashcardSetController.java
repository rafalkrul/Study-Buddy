package com.example.projektbackend.controller;

import com.example.projektbackend.DTO.flashcardset.FlashcardSetEditDTO;
import com.example.projektbackend.DTO.flashcardset.FlashcardSetGetDTO;
import com.example.projektbackend.DTO.flashcardset.FlashcardSetPostDTO;
import com.example.projektbackend.service.flashcardset.FlashcardSetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class FlashcardSetController {

    private final FlashcardSetService flashCardSetService;


    @PostMapping("/flashcardset")
    public ResponseEntity<UUID> CreateFlashcardSet(@RequestBody FlashcardSetPostDTO flashCardSetPostDTO) {
        var flashcardset_id = flashCardSetService.CreateFlashCardSet(flashCardSetPostDTO);
        return new ResponseEntity<>(flashcardset_id, HttpStatus.CREATED);
    }

    @GetMapping("/flashcardset/{flashcardsetId}")
    public ResponseEntity<FlashcardSetGetDTO> getFlashcardSetById(@PathVariable UUID flashcardsetId) {
        var flashcardSet = flashCardSetService.getFlashcardSetById(flashcardsetId);
        return new ResponseEntity<>(flashcardSet, HttpStatus.OK);
    }

    @GetMapping("/flashcardsets/{user_id}")
    public List<FlashcardSetGetDTO> getflashcardsByUserId(@PathVariable UUID user_id) {
        var flashcardSet = flashCardSetService.getAllFlashcardSetsByUserId(user_id);
        return flashcardSet;
    }

        @PostMapping("/flashcardset/add_flashcards")
    public ResponseEntity<Void> addFlashcardsInFlashcardSet(@RequestBody FlashcardSetEditDTO flashcardSetEditDTO){
        flashCardSetService.AddFlashcardsInFlashcardSet(flashcardSetEditDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/flashcardsetDelete/{flashcardId}")
    public ResponseEntity<Void> deleteFlashcardsetbyId(@PathVariable UUID flashcardId){
        flashCardSetService.deleteFlashcardSetById(flashcardId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/flashcardset/edit_flashcard")
    public ResponseEntity<Void> editFlashcardset(@RequestBody FlashcardSetEditDTO flashcardSetEditDTO){
        flashCardSetService.editFlashcardSet(flashcardSetEditDTO);
        return ResponseEntity.ok().build();
    }
}
