package com.solutionsone.mic.productservice.domain.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PersistErrorException extends RuntimeException{

    private String code;

    public PersistErrorException() {}

    public PersistErrorException(String code, String message) {
        super(message);
        this.code = code;
    }
}
