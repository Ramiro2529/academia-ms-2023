package com.ibm.academia.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }


}
