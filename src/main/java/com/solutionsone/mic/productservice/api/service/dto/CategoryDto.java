package com.solutionsone.mic.productservice.api.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    private String id;
    private String name;
    private String description;
    private String code;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private Boolean isActive;
}
