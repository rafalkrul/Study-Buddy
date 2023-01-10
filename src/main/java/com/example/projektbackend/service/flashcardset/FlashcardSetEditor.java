package com.example.projektbackend.service.flashcardset;

import com.example.projektbackend.DTO.flashcardset.FlashcardSetDTO;
import com.example.projektbackend.DTO.flashcardset.FlashcardSetEditDTO;
import com.example.projektbackend.model.Flashcard;
import com.example.projektbackend.model.FlashcardSet;
import com.example.projektbackend.repository.FlashcardRepository;
import com.example.projektbackend.repository.FlashcardSetRepository;
import com.example.projektbackend.service.flashcard.FlashcardValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FlashcardSetEditor {


    private final FlashcardSetRepository flashcardSetRepository;

    private final FlashcardValidator flashcardValidator;


    public void EditFlashcardSetData(FlashcardSetEditDTO flashcardSetEditDTO){

        var flashes = flashcardSetRepository.findById(flashcardSetEditDTO.getFlashcardset_id());

//        if(!flashcardSetEditDTO.getName().isBlank())
//            flashes.setName(flashcardSetEditDTO.getName());
//
//        if(!flashcardSetEditDTO.getDescription().isBlank())
//            flashes.setDescription(flashcardSetEditDTO.getDescription());

//        flashcardSetRepository.save(flashes);
    }

//    public void AddFlashcardsInFlashcardSet(UUID uuid, List<Flashcard> flashcards){
//
//        var flashcardSet = flashcardSetRepository.findById(uuid);
//
//        var flashcardlist = flashcardSet.stream().map(FlashcardSet::getFlashcards).collect(Collectors.toList());
//
//        flashcardValidator.ValidateFlashcardSet(flashcards);
//
//        flashcardlist.add(flashcards);
//
//
//    }


    public void AddFlashcardsInFlashcardSet(FlashcardSetEditDTO flashcardSetEditDTO){

        var flashcardSet = flashcardSetRepository.findById(flashcardSetEditDTO.getFlashcardset_id());

        var flashcardlist = flashcardSet.stream().map(FlashcardSet::getFlashcards).collect(Collectors.toList());

        flashcardValidator.ValidateFlashcardSet(flashcardSetEditDTO.getFlashcards());

        flashcardlist.add(flashcardSetEditDTO.getFlashcards());

//        flashcardSetRepository.save(flashcardSet);
    }

    //        flashcardSet.setName(name);
//        flashcardSet.setDescription(description);

//        flashcardSetRepository.save(flashcardSet);


}
