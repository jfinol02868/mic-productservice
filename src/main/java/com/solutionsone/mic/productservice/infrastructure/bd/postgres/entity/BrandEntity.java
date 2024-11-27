package com.solutionsone.mic.productservice.infrastructure.bd.postgres.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.TypeAlias;



@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "brands")
@TypeAlias("BrandEntity")
@EqualsAndHashCode(callSuper = true)
public class BrandEntity extends Auditable {

    @Id
    @Column(name = "id", nullable = false, unique = true, length = 100)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "logo_url")
    private String logoUrl;

    @Column(name = "website_url")
    private String websiteUrl;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
}
