package com.solutionsone.mic.productservice.infrastructure.bd.postgres.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.TypeAlias;

import java.time.ZonedDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "brands")
@TypeAlias("BrandEntity")
@EqualsAndHashCode(callSuper = true)
public class BrandEntity extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "logo_url", length = 255)
    private String logoUrl;

    @Column(name = "website_url", length = 255)
    private String websiteUrl;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "country_of_origin", length = 100)
    private String countryOfOrigin;

    @Column(name = "registration_date")
    private ZonedDateTime registrationDate;

    @Column(name = "is_exclusive")
    private Boolean isExclusive;

    @Column(name = "contact_info", length = 255)
    private String contactInfo;

    @Column(name = "average_rating")
    private Double averageRating;
}
