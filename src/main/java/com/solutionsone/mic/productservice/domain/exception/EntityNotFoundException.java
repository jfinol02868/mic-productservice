package com.solutionsone.mic.productservice.domain.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class EntityNotFoundException extends RuntimeException{

    private final String code;

    public EntityNotFoundException(String code) {
        this.code = code;
    }

    public EntityNotFoundException(String code, String message) {
        super(message);
        this.code = code;
    }
}
