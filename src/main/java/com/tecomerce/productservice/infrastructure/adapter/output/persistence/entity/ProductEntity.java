package com.tecomerce.productservice.infrastructure.adapter.output.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name =  "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "product_name", unique = true, length = 100)
    private String productName;

    @Column(name = "product_description", length = 250)
    private String productDescription;

    @Column(name = "product_stock")
    private Integer productStock;

    @Column(name = "product_weight")
    private Double productWeight;

    @Column(name = "product_availability")
    private Integer productAvailability;

    @Column(name = "product_creation_date")
    private ZonedDateTime productCreationDate;

    @Column(name = "product_update_date")
    private ZonedDateTime productUpdateDate;

    @PrePersist
    private void onCreated() {
        this.productCreationDate = ZonedDateTime.now(ZoneId.of("UTC"));
    }
}
