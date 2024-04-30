package com.tecomerce.productservice.infrastructure.adapter.input.rest;

import com.tecomerce.productservice.infrastructure.adapter.input.rest.service.SupplierApi;
import com.tecomerce.productservice.infrastructure.adapter.input.rest.service.dto.SupplierDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Suppliers")
@RequestMapping("/v1/suppliers")
public class SupplierController implements SupplierApi {

    @Override
    public ResponseEntity<SupplierDTO> create(SupplierDTO supplierDTO) {
        return SupplierApi.super.create(supplierDTO);
    }

    @Override
    public ResponseEntity<SupplierDTO> findById(String id) {
        return SupplierApi.super.findById(id);
    }

    @Override
    public ResponseEntity<List<SupplierDTO>> findAll() {
        return SupplierApi.super.findAll();
    }

    @Override
    public ResponseEntity<SupplierDTO> update(SupplierDTO supplierDTO, String id) {
        return SupplierApi.super.update(supplierDTO, id);
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        return SupplierApi.super.delete(id);
    }
}
