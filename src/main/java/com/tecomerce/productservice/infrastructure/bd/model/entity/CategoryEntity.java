package com.tecomerce.productservice.infrastructure.bd.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "categories")
public class CategoryEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String categoryName;
    private String categoryDescription;
    private String categoryParent;
    private List<ProductEntity> categoryProducts;
    private LocalDateTime categoryCreation;
    private LocalDateTime categoryUpdate;
    private List<String> categoryUrlImages;
    private String categoryStatus;
    private List<String> categoryLabels;

}
