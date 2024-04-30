package com.tecomerce.productservice.infrastructure.adapter.output.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name =  "categories")
public class CategoryEntity {

    @Id
    private String id;
    private String categoryName;
    private String categoryDescription;
    private String categoryParent;
    private LocalDateTime categoryCreation;
    private LocalDateTime categoryUpdate;
    private List<String> categoryUrlImages;
    private String categoryStatus;
    private List<String> categoryLabels;
}
