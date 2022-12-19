package com.example.projektbackend.service.flashcard;

import com.example.projektbackend.DTO.flashcard.FlashcardDTO;
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

        flashcardValidator.ValidateFlashcard(flashcardDTO);

        flashcardRepository.save(flashcardAdd);

        return id;

    }
}
