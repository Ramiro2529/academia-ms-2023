package com.ibm.academia.user.exception.controller;

import com.ibm.academia.user.exception.BadRequestExceptionBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(BadRequestExceptionBody.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handle(BadRequestExceptionBody ex) {
        Map<String, Object> response = new HashMap<>();

        response.put("message", ex.getMessage());
        response.put("errors", ex.getErrors());
        return response;
    }
}
