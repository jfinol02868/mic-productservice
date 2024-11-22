package com.solutionsone.mic.productservice.domain.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PersistErrorException extends RuntimeException{

    private final String code;

    public PersistErrorException(String code) {
        this.code = code;
    }

    public PersistErrorException(String code, String message) {
        super(message);
        this.code = code;
    }
}
