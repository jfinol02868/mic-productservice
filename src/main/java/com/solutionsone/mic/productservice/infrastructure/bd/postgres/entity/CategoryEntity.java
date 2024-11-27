package com.solutionsone.mic.productservice.infrastructure.bd.postgres.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "categories")
@EqualsAndHashCode(callSuper = true)
public class CategoryEntity extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "slug", unique = true, nullable = false, length = 100)
    private String slug;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @OneToMany(mappedBy = "parentCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CategoryEntity> subcategories;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private CategoryEntity parentCategory;
}
