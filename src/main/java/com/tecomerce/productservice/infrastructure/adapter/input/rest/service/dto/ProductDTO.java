package com.tecomerce.productservice.infrastructure.adapter.input.rest.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO implements Serializable  {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(example = "bc36bacd-b110-4aa3-a083-fe9c5a3404b6")
    private String id;

    @Schema(example = "Lapiz")
    @NotNull(message = "Field product name cannot be empty or null.")
    private String productName;

    @Schema(example = "Lapiz de grafito para escribir en cuaderno tradicional")
    private String productDescription;

    @Schema(example = "2000")
    @NotNull(message = "Field product stock cannot be empty or null.")
    private Integer productStock;

    @Schema(example = "0.10")
    @NotNull(message = "Field product weight cannot be empty or null.")
    private Double productWeight;

    @Schema(example = "2000")
    @NotNull(message = "Field product availability cannot be empty or null.")
    private Integer productAvailability;

    @Schema(example = "2024-05-01T20:35:10")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private ZonedDateTime productCreationDate;

    @Schema(example = "2024-05-01T20:35:10")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private ZonedDateTime productUpdateDate;
}
