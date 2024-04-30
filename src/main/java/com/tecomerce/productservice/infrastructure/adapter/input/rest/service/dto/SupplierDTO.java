package com.tecomerce.productservice.infrastructure.adapter.input.rest.service.dto;

import lombok.*;

import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDTO {

    private String id;
    private String supplierName;
    private String supplierDescription;
}
