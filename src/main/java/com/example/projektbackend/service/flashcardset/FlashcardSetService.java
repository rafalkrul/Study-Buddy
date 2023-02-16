package com.example.projektbackend.service.flashcardset;

import com.example.projektbackend.DTO.flashcardset.FlashcardSetDTO;
import com.example.projektbackend.DTO.flashcardset.FlashcardSetEditDTO;
import com.example.projektbackend.DTO.flashcardset.FlashcardSetGetDTO;
import com.example.projektbackend.DTO.flashcardset.FlashcardSetPostDTO;
import com.example.projektbackend.DTO.quiz.QuizEditDTO;
import com.example.projektbackend.DTO.quiz.QuizGetDTO;
import com.example.projektbackend.model.Flashcard;
import com.example.projektbackend.model.FlashcardSet;
import com.example.projektbackend.model.Question;
import com.example.projektbackend.model.Quiz;
import com.example.projektbackend.repository.FlashcardRepository;
import com.example.projektbackend.repository.FlashcardSetRepository;
import com.example.projektbackend.service.flashcard.FlashcardValidator;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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



        flashcardValidator.ValidateFlashcardSet(flashcardsAdd);

       flashcardSet.setFlashcards(flashcardsAdd);

       // flashcardRepository.saveAll(flashcardsAdd);

        flashcardSetRepository.save(flashcardSet);

        return id;
    }



    public List<FlashcardSetGetDTO> getAllFlashcardSetsByUserId(UUID user_id){
        List<FlashcardSet> flashcardSet = flashcardSetRepository.findAllByUserId(user_id);
        List<FlashcardSetGetDTO> flashcardSetList = flashcardSet.stream()
                .map(flashcardSet1 -> mapper.map(flashcardSet1, FlashcardSetGetDTO.class))
                .collect(Collectors.toList());



        return flashcardSetList;
    }




    public void AddFlashcardsInFlashcardSet(FlashcardSetEditDTO flashcardSetEditDTO){

        var flashcardSet = flashcardSetMapper(flashcardSetEditDTO);

        var flashcards = flashcardSetEditDTO.getFlashcardsDTO()
                .stream()
                .map(flashcardDTO -> mapper.map(flashcardDTO, Flashcard.class))
                .collect(Collectors.toList());

        flashcardValidator.ValidateFlashcardSet(flashcards);

        flashcardSet.getFlashcards().addAll(flashcards);

        flashcardSetRepository.save(flashcardSet);
    }


    public FlashcardSetGetDTO getFlashcardSetById(UUID flashcardsetId){
        var flashcardSet = flashcardSetRepository.findById(flashcardsetId).orElseThrow(() -> new RuntimeException("dfsdfsdfs"));
        FlashcardSetGetDTO flashcardSetGetDTO = mapper.map(flashcardSet,FlashcardSetGetDTO.class);
        flashcardSetGetDTO.setFlashcardsDTO(flashcardSet.getFlashcards());
        return flashcardSetGetDTO;
    }


    public FlashcardSet flashcardSetMapper(FlashcardSetEditDTO flashcardSetEditDTO){

        var flashcardSet = flashcardSetRepository.findById(flashcardSetEditDTO.getId());

        return mapper.map(flashcardSet, FlashcardSet.class);
    }

    public void deleteFlashcardSetById(UUID flashcardsetId){
         flashcardSetRepository.deleteById(flashcardsetId);
    }

    public void editFlashcardSet(FlashcardSetEditDTO flashcardSetEditDTO){
        var flashcardset = flashcardSetMapper(flashcardSetEditDTO);

        if(!flashcardSetEditDTO.getName().isBlank())
            flashcardset.setName(flashcardSetEditDTO.getName());
        if(!flashcardSetEditDTO.getDescription().isBlank())
            flashcardset.setDescription(flashcardSetEditDTO.getDescription());

        flashcardSetRepository.save(flashcardset);

    }

}
