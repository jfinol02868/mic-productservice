package com.tecomerce.productservice.utils;

public enum ErrorCatalog {

    NOT_FOUND("E404","Record not found."),
    INVALID_PARAMETERS("E400","Invalid parameters."),
    GENERIC_ERROR("E500","An unexpected error occurred.");

    private final String code;
    private final String message;

    ErrorCatalog(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
