package com.solutionsone.mic.productservice.api;

import com.solutionsone.mic.productservice.api.service.dto.MessageResponseDTO;
import com.solutionsone.mic.productservice.domain.exception.ErrorMappingException;
import com.solutionsone.mic.productservice.domain.exception.PageNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

@RestControllerAdvice
public class ControlAdviceException {


    @ExceptionHandler(PageNotValidException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(PageNotValidException ex, WebRequest request) {
        return new ResponseEntity<>(
                MessageResponseDTO.builder()
                        .code(ex.getCode())
                        .details(List.of())
                        .message(ex.getMessage())
                        .timeStamp(ZonedDateTime.now(ZoneId.of("UTC")))
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ErrorMappingException.class)
    public ResponseEntity<Object> handleGlobalException(ErrorMappingException ex, WebRequest request) {
        return new ResponseEntity<>(
                MessageResponseDTO.builder()
                        .code(ex.getCode())
                        .details(List.of())
                        .message(ex.getMessage())
                        .timeStamp(ZonedDateTime.now(ZoneId.of("UTC")))
                        .build(), HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public MessageResponseDTO handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return MessageResponseDTO.builder()
                .code("AI001")
                .message("Argumentos requeridos.")
                .details(e.getBindingResult()
                        .getFieldErrors()
                        .stream()
                        .map(fieldError -> fieldError.getField().concat(": ").concat(Objects.requireNonNull(fieldError.getDefaultMessage())))
                        .toList())
                .timeStamp(ZonedDateTime.now())
                .build();
    }
}
