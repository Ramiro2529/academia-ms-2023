package com.ibm.academia.user.exception;

import com.ibm.academia.user.model.BadRequestBodyField;
import lombok.Data;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class BadRequestExceptionBody extends RuntimeException{

    private List<BadRequestBodyField> errors;

    public BadRequestExceptionBody(String message, List<FieldError> errors) {
        super(message);
        this.errors = errors.stream()
                .map(BadRequestBodyField::fromFieldError)
                .collect(Collectors.toList());
    }

}
