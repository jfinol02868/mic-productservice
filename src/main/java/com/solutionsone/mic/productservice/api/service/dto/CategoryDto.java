package com.solutionsone.mic.productservice.api.service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    @Schema(description = "The unique identifier of the category", example = "1")
    private Long id;

    @Schema(description = "The name of the category", example = "Electronics")
    private String name;

    @Schema(description = "A brief description of the category", example = "Devices and gadgets")
    private String description;

    @Schema(description = "The slug for the category, used in URLs", example = "electronics")
    private String slug;

    @Schema(description = "Indicates if the category is active", example = "true")
    private Boolean isActive;

    @Schema(description = "The subcategories of the category",  example = "[1, 2]")
    private List<Long> subcategories;
}
