package com.example.projektbackend.service.flashcard;

import com.example.projektbackend.DTO.flashcard.FlashcardDTO;
import com.example.projektbackend.DTO.flashcard.FlashcardGetDTO;
import com.example.projektbackend.model.Flashcard;
import com.example.projektbackend.repository.FlashcardRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FlashcardService {

    private final FlashcardRepository flashcardRepository;

    private final FlashcardValidator flashcardValidator;

    private final ModelMapper mapper;


    public UUID CreateFlashcard(FlashcardDTO flashcardDTO){

        UUID id = UUID.randomUUID();

        var flashcardAdd = mapper.map(flashcardDTO, Flashcard.class);

//        flashcardValidator.ValidateFlashcard(flashcardDTO);

        flashcardRepository.save(flashcardAdd);

        return id;

    }

    public void deleteFlashcardById(FlashcardGetDTO flashcardGetDTO){
        flashcardRepository.deleteById(flashcardGetDTO.getId());
    }

    public void editFlashcard(FlashcardGetDTO flashcardGetDTO){
        var flashcard = flashcardMapper(flashcardGetDTO);

        if(!flashcardGetDTO.getWord().isBlank())
            flashcardValidator.validateWord(flashcardGetDTO.getWord());
            flashcard.setWord(flashcard.getWord());
        if(!flashcardGetDTO.getTranslation().isBlank())
            flashcardValidator.validateTranslation(flashcardGetDTO.getTranslation());
            flashcard.setTranslation(flashcard.getTranslation());
    }


    public FlashcardGetDTO flashcardMapper(FlashcardGetDTO flashcardGetDTO){
        var flashcard = flashcardRepository.findById(flashcardGetDTO.getId());
        return mapper.map(flashcard,FlashcardGetDTO.class);
    }





}
