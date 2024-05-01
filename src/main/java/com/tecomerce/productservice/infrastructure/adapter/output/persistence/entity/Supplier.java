package com.tecomerce.productservice.infrastructure.adapter.output.persistence.entity;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {

    private String id;
    private String supplierName;
    private String supplierEmail;
    private String supplierPhone;
    private String supplierStatus;
    private String productsSupplied;
    private String supplierDescription;
}
