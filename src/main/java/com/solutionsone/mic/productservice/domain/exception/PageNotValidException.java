package com.solutionsone.mic.productservice.domain.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PageNotValidException extends RuntimeException {

    private final String code;

    public PageNotValidException(String code) {
        this.code = code;
    }

    public PageNotValidException(String code, String message) {
        super(message);
        this.code = code;
    }
}
