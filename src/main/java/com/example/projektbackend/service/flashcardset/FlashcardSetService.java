package com.example.projektbackend.service.flashcardset;

import com.example.projektbackend.DTO.flashcardset.FlashcardSetDTO;
import com.example.projektbackend.DTO.flashcardset.FlashcardSetEditDTO;
import com.example.projektbackend.DTO.flashcardset.FlashcardSetPostDTO;
import com.example.projektbackend.model.Flashcard;
import com.example.projektbackend.model.FlashcardSet;
import com.example.projektbackend.repository.FlashcardRepository;
import com.example.projektbackend.repository.FlashcardSetRepository;
import com.example.projektbackend.service.flashcard.FlashcardValidator;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FlashcardSetService {



    private final FlashcardSetRepository flashcardSetRepository;

    private final FlashcardRepository flashcardRepository;

    private final FlashcardValidator flashcardValidator;
    private final ModelMapper mapper;


    public UUID CreateFlashCardSet(FlashcardSetPostDTO flashcardSetPostDTO){

        UUID id = UUID.randomUUID();

        FlashcardSet flashcardSet = mapper.map(flashcardSetPostDTO.getFlashcardSetDTO(), FlashcardSet.class);

        var flashcardsAdd = flashcardSetPostDTO.getFlashcardsDTO()
                .stream()
                .map(FlashcardDTO -> mapper.map(FlashcardDTO, Flashcard.class))
                .collect(Collectors.toList());

       // flashcardValidator.ValidateFlashcard(flashcardsAdd);

        flashcardValidator.ValidateFlashcardSet(flashcardsAdd);

       flashcardSet.setFlashcards(flashcardsAdd);

       // flashcardRepository.saveAll(flashcardsAdd);

        flashcardSetRepository.save(flashcardSet);

        return id;
    }





    public void AddFlashcardsInFlashcardSet(UUID uuid, List<Flashcard> flashcards){

        var flashcardSet = flashcardSetRepository.findById(uuid);

        var flashcardlist = flashcardSet.stream().map(FlashcardSet::getFlashcards).collect(Collectors.toList());

        flashcardValidator.ValidateFlashcardSet(flashcards);

        flashcardlist.add(flashcards);


    }



}
