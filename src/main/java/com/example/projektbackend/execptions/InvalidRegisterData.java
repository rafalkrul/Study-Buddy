package com.example.projektbackend.execptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidRegisterData extends RuntimeException {

    public InvalidRegisterData(String message){
        super(message);
    }
}
