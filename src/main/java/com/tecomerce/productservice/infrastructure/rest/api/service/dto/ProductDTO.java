package com.tecomerce.productservice.infrastructure.rest.api.service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO implements Serializable  {

    @Schema(example = "")
    private UUID id;

    @Schema(example = "Lapiz")
    private String productName;

    @Schema(example = "Lapiz de grafito para escribir en cuaderno tradicional")
    private String productDescription;

    @Schema(example = "2000")
    private Integer productStock;

    @Schema(example = "0.10")
    private Double ProductWeight;

    @Schema(example = "2000")
    private Integer productAvailability;

    @Schema(example = "2024-05-01T20:35:10")
    private ZonedDateTime productCreationDate;

    @Schema(example = "2024-05-01T20:35:10")
    private ZonedDateTime productUpdateDate;
}
