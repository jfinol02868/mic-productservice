package com.solutionsone.mic.productservice.domain.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class FiledRequireException extends RuntimeException {

    private final String code;
    private final List<String> details;

    public FiledRequireException(String code, String message, List<String> details) {
        super(message);
        this.code = code;
        this.details = details;
    }
}
