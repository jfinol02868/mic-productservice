package com.solutionsone.mic.productservice.api.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stockQuantity;
    private String category;
    private String barcode;
    private String brand;
    private BigDecimal weight;
    private String dimensions;
    private String color;
    private String size;
    private BigDecimal discount;
    private String status;
    private String supplier;
    private List<String> images;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
    private LocalDateTime expirationDate;
    private String manufacturer;
    private String shippingType;
    private String shippingOrigin;
    private String shippingRegion;
    private String shippingCost;
    private String shippingTime;

}
