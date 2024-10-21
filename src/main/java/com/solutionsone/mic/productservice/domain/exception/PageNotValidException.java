package com.solutionsone.mic.productservice.domain.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PageNotValidException extends RuntimeException {

    private String code;

    public PageNotValidException() {}

    public PageNotValidException(String code, String message) {
        super(message);
        this.code = code;
    }
}
