package com.tecomerce.productservice.infrastructure.bd.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Entity(name = "products")
public class ProductEntity implements Serializable {

    //@Id
    //@Column(name = "id")
    //@GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String productName;
    private String productDescription;
    private Integer productStock;
    private Double ProductWeight;
    private Integer productAvailability;
    private ZonedDateTime productCreationDate;
    private ZonedDateTime productUpdateDate;

//    private List<Discount> productDiscounts;
//    private List<Discount> productPromotions;
//    private List<Taxe> productTaxes;
//    private List<Rating> productRating;
//    private List<String> productLabels;
//    private List<Campaign> campaigns;
//    private List<Size> productSizes;
}
