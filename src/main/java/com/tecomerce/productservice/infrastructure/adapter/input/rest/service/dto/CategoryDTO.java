package com.tecomerce.productservice.infrastructure.adapter.input.rest.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO implements Serializable {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(example = "")
    private String id;
    @Schema(example = "")
    private String categoryName;
    @Schema(example = "")
    private String categoryDescription;
    @Schema(example = "")
    private String categoryParent;
    @Schema(example = "")
    private LocalDateTime categoryCreation;
    @Schema(example = "")
    private LocalDateTime categoryUpdate;
    @Schema(example = "")
    private List<String> categoryUrlImages;
    @Schema(example = "")
    private String categoryStatus;
    @Schema(example = "")
    private List<String> categoryLabels;

}
