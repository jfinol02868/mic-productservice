package com.tecomerce.productservice.infrastructure.adapter.output.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name =  "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String productName;

    private String productDescription;

    private Integer productStock;

    private Double productWeight;

    private Integer productAvailability;

    private ZonedDateTime productCreationDate;

    private ZonedDateTime productUpdateDate;

}
