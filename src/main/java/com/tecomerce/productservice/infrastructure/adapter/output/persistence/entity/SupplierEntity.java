package com.tecomerce.productservice.infrastructure.adapter.output.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "suppliers")
public class SupplierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "supplier_name", length = 50)
    private String supplierName;

    @Column(name = "supplier_email", length = 100)
    private String supplierEmail;

    @Column(name = "supplier_phone", length = 15)
    private String supplierPhone;

    @Column(name = "supplier_status", length = 20)
    private String supplierStatus;

    @Column(name = "supplier_products", length = 250)
    private String productsSupplied;

    @Column(name = "supplier_description", length = 250)
    private String supplierDescription;
}
