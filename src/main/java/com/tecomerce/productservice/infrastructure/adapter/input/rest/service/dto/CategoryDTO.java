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
    @Schema(example = "bc36bacd-b110-4aa3-a083-fe9c5a3404b6")
    private String id;
    @Schema(example = "Shoes")
    private String categoryName;
    @Schema(example = "Shoes for running")
    private String categoryDescription;
    @Schema(example = "PENDING")
    private String categoryParent;
    @Schema(example = "2024-05-01T20:35:10")
    private LocalDateTime categoryCreation;
    @Schema(example = "2024-05-01T20:35:10")
    private LocalDateTime categoryUpdate;
    @Schema(example = "http://bucket/pet.png")
    private List<String> categoryUrlImages;
    @Schema(example = "Active")
    private String categoryStatus;
    @Schema(example = "['NEW', 'RUNNING']")
    private List<String> categoryLabels;

}
