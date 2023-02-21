package com.example.projektbackend.service.flashcard;

import com.example.projektbackend.DTO.flashcard.FlashcardDTO;

import com.example.projektbackend.execptions.InvalidFlashcardData;
import com.example.projektbackend.model.Flashcard;
import com.example.projektbackend.repository.FlashcardRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FlashcardValidator {
    
    private static final String regex = "^[a-zA-ZąćęłńóśźżĄĆĘŁŃÓŚŹŻ]+$";

    private final ModelMapper mapper;
    private final FlashcardRepository flashcardRepository;


    public void ValidateFlashcard(FlashcardDTO flashcardDTO){

        validateWord(flashcardDTO.getWord());

        validateTranslation(flashcardDTO.getTranslation());

    }

    public void validateWord(String word){
        if(!word.matches(regex))
            throw new InvalidFlashcardData("Podane słowo zawiera znaki inne niż litery");

    }

    public void validateTranslation(String translation){
        if(!translation.matches(regex))
            throw new InvalidFlashcardData("Podane słowo zawiera znaki inne niż litery");

    }
    
    public void ValidateFlashcardSet(List<Flashcard> flashcardList){

        if(!flashcardList.isEmpty()){

            if (flashcardList.stream().anyMatch(flashcard -> !flashcard.getTranslation().matches(regex) || !flashcard.getWord().matches(regex))) {
                throw new InvalidFlashcardData("W zestawie fiszek znajdują się znaki nie będące literami");
            }

        }else {
            throw new InvalidFlashcardData("W zestawie nie ma fiszek");
        }

    }
}
