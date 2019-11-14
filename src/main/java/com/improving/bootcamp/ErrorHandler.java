package com.improving.bootcamp;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Model model, Exception e){
        model.addAttribute("errorMessage", e.getMessage());
        System.out.println(e.getMessage());
        return "error";
    }


    @ExceptionHandler(TeaPotException.class)
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public String exceptionHandler(Model model, TeaPotException e){
        model.addAttribute("errorMessage", e.getMessage());
        System.out.println(e.getMessage());
        return "error";
    }


}
