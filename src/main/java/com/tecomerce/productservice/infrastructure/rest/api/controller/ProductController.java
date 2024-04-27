package com.tecomerce.productservice.infrastructure.rest.api.controller;

import com.tecomerce.productservice.infrastructure.rest.api.service.ProductApi;
import com.tecomerce.productservice.infrastructure.rest.api.service.dto.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/products")
public class ProductController implements ProductApi {

    @Override
    public ResponseEntity<List<ProductDTO>> getAll() {
        return ProductApi.super.getAll();
    }
}
