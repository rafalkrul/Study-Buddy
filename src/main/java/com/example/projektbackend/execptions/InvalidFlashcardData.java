package com.example.projektbackend.execptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidFlashcardData extends RuntimeException{

    public InvalidFlashcardData(String message){
        super(message);
    }
}
