package com.solutionsone.mic.productservice.api.service.dto;

import lombok.Getter;

@Getter
public enum SortEnumDTO {

    ASC("ASC"),
    DESC("DESC");

    private final String value;

    SortEnumDTO(String value) {
        this.value = value;
    }
}
