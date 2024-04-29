package com.tecomerce.productservice.infrastructure.adapter.input.rest;

import com.tecomerce.productservice.infrastructure.adapter.input.rest.service.ProductApi;
import com.tecomerce.productservice.infrastructure.adapter.input.rest.service.dto.ProductDTO;
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
