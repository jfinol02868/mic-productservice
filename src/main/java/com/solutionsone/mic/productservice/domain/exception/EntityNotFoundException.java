package com.solutionsone.mic.productservice.domain.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class EntityNotFoundException extends RuntimeException{

    private String code;

    public EntityNotFoundException() {
        super();
    }

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, String code) {
        super(message);
        this.code = code;
    }
}
