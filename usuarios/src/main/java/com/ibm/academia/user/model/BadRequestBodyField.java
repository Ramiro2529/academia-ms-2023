package com.ibm.academia.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.validation.FieldError;

@Data
@AllArgsConstructor
public class BadRequestBodyField {

    private String fieldName;
    private String rejectedValue;
    private String defaultMessage;

    public static BadRequestBodyField fromFieldError(FieldError error) {
        return new BadRequestBodyField(error.getField(), "" + error.getRejectedValue(), error.getDefaultMessage());
    }
}
