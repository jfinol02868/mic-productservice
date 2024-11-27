package com.solutionsone.mic.productservice.domain.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ErrorMappingException extends RuntimeException {

    private final String code;

    public ErrorMappingException(String code) {
        this.code = code;
    }

    public ErrorMappingException(String code, String message) {
        super(message);
        this.code = code;
    }
}
