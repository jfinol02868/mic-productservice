package com.tecomerce.productservice.infrastructure.adapter.input.rest.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO implements Serializable {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(example = "bc36bacd-b110-4aa3-a083-fe9c5a3404b6")
    private String id;

    @Schema(example = "Shoes")
    @NotNull(message = "File category name cannot by empty or null.")
    private String categoryName;

    @Schema(example = "Shoes for running")
    private String categoryDescription;

    @Schema(example = "PENDING")
    private String categoryParent;

    @ArraySchema(schema = @Schema(implementation = String.class))
    private List<String> categoryUrlImages;

    @Schema(example = "Active")
    private String categoryStatus;

    @ArraySchema(schema = @Schema(implementation = String.class))
    private List<String> categoryLabels;

    @Schema(example = "2024-05-01T20:35:10")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private ZonedDateTime categoryCreationDate;

    @Schema(example = "2024-05-01T20:35:10")
    private ZonedDateTime categoryUpdateDate;

}
