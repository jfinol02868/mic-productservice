package com.tecomerce.productservice.domain.model;

import lombok.*;

@Builder
@Getter
@Setter
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
