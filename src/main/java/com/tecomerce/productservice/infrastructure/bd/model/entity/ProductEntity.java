package com.tecomerce.productservice.infrastructure.bd.model.entity;

import jakarta.persistence.*;
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
@Entity(name = "products")
public class ProductEntity implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String productName;
    private String productDescription;
    private Integer productStock;
    private List<CategoryEntity> productCategory;
    private List<Supplier> productSupplier;
    private List<Image> productImages;
    private Double ProductWeight;
    private List<Size> productSizes;
    private Integer productAvailability;
    private List<Discount> productDiscounts;
    private List<Discount> productPromotions;
    private List<Taxe> productTaxes;
    private List<Rating> productRating;
    private List<String> productLabels;
    private List<Campaign> campaigns;
    private LocalDateTime productCreationDate;
    private LocalDateTime productUpdateDate;
}
