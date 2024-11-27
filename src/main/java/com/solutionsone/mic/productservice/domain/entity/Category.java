package com.solutionsone.mic.productservice.domain.entity;

import com.solutionsone.mic.productservice.infrastructure.bd.postgres.entity.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    private Long id;
    private String name;
    private String description;
    private String slug;
    private Boolean isActive;
    private List<CategoryEntity> subcategories;
}
