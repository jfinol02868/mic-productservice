package com.solutionsone.mic.productservice.domain.util;

import lombok.Getter;

@Getter
public enum Message {

    ERROR_PAGINATED("PG001", "El numero de página no es válido, verifique los valores de la paginación."),
    ERROR_MAPPING("MP001", "Una excepción ocurrió al mapear el objeto, verifique las propiedades que esta enviando en su filterProperties."),
    ACCESS_FIELD_ERROR("AC001", "El campo %s no es accesible."),
    FIELD_REQUIRE("BF001", "Revisar los campos obligatorios."),
    BRAND_NOT_FOUND("EN001", "El registro con id: %s no existe.");

    private final String value;
    private final String code;

    Message( String code, String value) {
        this.value = value;
        this.code = code;
    }
}
