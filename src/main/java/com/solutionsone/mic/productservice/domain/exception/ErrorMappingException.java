package com.solutionsone.mic.productservice.domain.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ErrorMappingException extends RuntimeException {

    private String code;

    public ErrorMappingException() {}

    public ErrorMappingException(String code, String message) {
        super(message);
        this.code = code;
    }
}
