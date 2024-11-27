package com.solutionsone.mic.productservice.api;

import com.solutionsone.mic.productservice.api.service.dto.MessageResponseDTO;
import com.solutionsone.mic.productservice.domain.exception.*;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {


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

    @ExceptionHandler(PersistErrorException.class)
    public ResponseEntity<Object> persistErrorException(PersistErrorException ex, WebRequest request) {
        return new ResponseEntity<>(
                MessageResponseDTO.builder()
                        .code("PE001")
                        .details(List.of())
                        .message("Error al intentar persistir de forma masiva.")
                        .timeStamp(ZonedDateTime.now(ZoneId.of("UTC")))
                        .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> entityNotFoundException(EntityNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(
                MessageResponseDTO.builder()
                        .code(ex.getCode())
                        .details(List.of(
                                "Asegurese de que el id que esta enviando exista en la base de datos.",
                                "Si envió mas de un registro, recuerde que no se eliminara ninguno si no coinciden todos."))
                        .message(ex.getMessage())
                        .timeStamp(ZonedDateTime.now(ZoneId.of("UTC")))
                        .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FiledRequireException.class)
    public ResponseEntity<Object> fieldRequireException(FiledRequireException ex, WebRequest request) {
        return new ResponseEntity<>(
                MessageResponseDTO.builder()
                        .code(ex.getCode())
                        .details(ex.getDetails())
                        .message(ex.getMessage())
                        .timeStamp(ZonedDateTime.now(ZoneId.of("UTC")))
                        .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> httpMessageNotReadableException(HttpMessageNotReadableException ex, WebRequest request) {
        return new ResponseEntity<>(
                MessageResponseDTO.builder()
                        .code("JE001")
                        .details(List.of())
                        .message("Hay un error en la estructura del JSON, revisar el body que se esta enviando.")
                        .timeStamp(ZonedDateTime.now(ZoneId.of("UTC")))
                        .build(), HttpStatus.NOT_FOUND);
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
                        .map(fieldError -> fieldError.getField().concat(": ")
                                .concat(Objects.requireNonNull(fieldError.getDefaultMessage())))
                        .toList())
                .timeStamp(ZonedDateTime.now(ZoneId.of("UTC")))
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(AccessToFieldException.class)
    public MessageResponseDTO handlerMethodArgumentNotValidException(AccessToFieldException e) {
        return MessageResponseDTO.builder()
                .code(e.getCode())
                .message(e.getMessage())
                .details(new ArrayList<>())
                .timeStamp(ZonedDateTime.now(ZoneId.of("UTC")))
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PropertyReferenceException.class)
    public MessageResponseDTO handlerPropertyReferenceException(PropertyReferenceException e) {
        return MessageResponseDTO.builder()
                .code("PR001")
                .message("Esta enviando alguna propiedad de forma incorrecta.")
                .details(new ArrayList<>(List.of(e.getPropertyName())))
                .timeStamp(ZonedDateTime.now(ZoneId.of("UTC")))
                .build();
    }
}
