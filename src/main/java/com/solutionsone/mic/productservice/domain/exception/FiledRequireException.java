package com.solutionsone.mic.productservice.domain.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FiledRequireException extends RuntimeException {

    private String code;

    public FiledRequireException(String code, String message) {
        super(message);
        this.code = code;
    }
}
