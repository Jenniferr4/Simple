package com.improving.bootcamp;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
public class TeaPotException extends RuntimeException{

    public TeaPotException(){
        super("I am a teapot!");
    }


}
