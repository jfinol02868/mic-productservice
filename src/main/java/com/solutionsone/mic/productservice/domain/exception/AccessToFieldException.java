package com.solutionsone.mic.productservice.domain.exception;

import lombok.Getter;

@Getter
public class AccessToFieldException extends RuntimeException{

    private final String code;

    public AccessToFieldException(String code, String message) {
        super(message);
        this.code = code;
    }

}
