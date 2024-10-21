package com.solutionsone.mic.productservice.domain.util;

import lombok.Getter;

@Getter
public enum Message {

    ERROR_PAGINATED("PG001", "El numero de página no es válido, verifique los valores de la paginación."),
    ERROR_MAPPING("MP001", "Una excepción ocurrió al mapear el objeto, verifique las propiedades que esta enviando en su filterProperties.");

    private final String message;
    private final String code;

    Message( String code, String message) {
        this.message = message;
        this.code = code;
    }
}
