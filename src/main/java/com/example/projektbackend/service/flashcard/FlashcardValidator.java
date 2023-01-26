package com.example.projektbackend.service.flashcard;

import com.example.projektbackend.DTO.flashcard.FlashcardDTO;
import com.example.projektbackend.DTO.flashcardset.FlashcardSetPostDTO;
import com.example.projektbackend.execptions.InvalidFlashcardData;
import com.example.projektbackend.model.Flashcard;
import com.example.projektbackend.repository.FlashcardRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FlashcardValidator {
    
    private static final String regex = "^[a-zA-ZąćęłńóśźżĄĆĘŁŃÓŚŹŻ]+$";

    private final ModelMapper mapper;
    private final FlashcardRepository flashcardRepository;


    public void ValidateFlashcard(FlashcardDTO flashcardDTO){
        
        if(!flashcardDTO.getWord().matches(regex) || !flashcardDTO.getTranslation().matches(regex))
            throw new InvalidFlashcardData("Podane słowo zawiera znaki inne niż litery");
        
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

            if(flashcardList.stream().map(Flashcard::getTranslation).allMatch(n -> n.matches(regex)) || flashcardList.stream().map(Flashcard::getWord).allMatch(n -> n.matches(regex)))
                throw new InvalidFlashcardData("W zestawie fiszek znajdują się znaki nie będące literami");

        }

    }
}
