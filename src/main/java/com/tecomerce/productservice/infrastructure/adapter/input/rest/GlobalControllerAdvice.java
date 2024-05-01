package com.tecomerce.productservice.infrastructure.adapter.input.rest;

import com.tecomerce.productservice.domain.exception.EntityNotFoundException;
import com.tecomerce.productservice.domain.exception.ErrorResponse;
import com.tecomerce.productservice.utils.ErrorCatalog;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public ErrorResponse handlerEntityNotFoundException() {
        return ErrorResponse.builder()
                .code(ErrorCatalog.NOT_FOUND.getCode())
                .message(ErrorCatalog.NOT_FOUND.getMessage())
                .details(new ArrayList<>())
                .timeStamp(ZonedDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ErrorResponse.builder()
                .code(ErrorCatalog.INVALID_PARAMETERS.getCode())
                .message(ErrorCatalog.INVALID_PARAMETERS.getMessage())
                .details(e.getBindingResult()
                        .getFieldErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .toList())
                .timeStamp(ZonedDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handlerGenericError(Exception e) {
        return ErrorResponse.builder()
                .code(ErrorCatalog.GENERIC_ERROR.getCode())
                .message(ErrorCatalog.GENERIC_ERROR.getMessage())
                .details(Collections.singletonList(e.getMessage()))
                .timeStamp(ZonedDateTime.now())
                .build();
    }
}
