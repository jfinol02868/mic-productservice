package com.tecomerce.productservice.domain.model;

import jakarta.persistence.PrePersist;
import lombok.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private String id;
    private String productName;
    private String productDescription;
    private Integer productStock;
    private Double productWeight;
    private Integer productAvailability;
    private ZonedDateTime productCreationDate;
    private ZonedDateTime productUpdateDate;

}
