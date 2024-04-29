package com.tecomerce.productservice.domain.model;

import lombok.*;

import java.time.ZonedDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private UUID id;

    private String productName;

    private String productDescription;

    private Integer productStock;

    private Double productWeight;

    private Integer productAvailability;

    private ZonedDateTime productCreationDate;

    private ZonedDateTime productUpdateDate;

}
