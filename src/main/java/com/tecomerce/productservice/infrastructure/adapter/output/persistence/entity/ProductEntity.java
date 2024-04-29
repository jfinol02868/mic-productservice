package com.tecomerce.productservice.infrastructure.adapter.output.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.ZonedDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name =  "products")
public class ProductEntity {

    @Id
    private String id;

    private String productName;

    private String productDescription;

    private Integer productStock;

    private Double productWeight;

    private Integer productAvailability;

    private ZonedDateTime productCreationDate;

    private ZonedDateTime productUpdateDate;

}
