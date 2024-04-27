package com.tecomerce.productservice.infrastructure.rest.api.service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageResponse implements Serializable {

    @Schema(example = "E001")
    private String code;
    @Schema(example = "Message error description.")
    private String message;
}
