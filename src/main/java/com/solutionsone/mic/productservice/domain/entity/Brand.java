package com.solutionsone.mic.productservice.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Brand {

    private Long id;
    private String name;
    private String description;
    private String logoUrl;
    private String websiteUrl;
    private Boolean isActive;
}
