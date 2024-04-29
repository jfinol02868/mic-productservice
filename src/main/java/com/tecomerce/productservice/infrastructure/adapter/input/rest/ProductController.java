package com.tecomerce.productservice.infrastructure.adapter.input.rest;

import com.tecomerce.productservice.application.ports.input.ProductCrudUseCase;
import com.tecomerce.productservice.infrastructure.adapter.input.rest.service.ProductApi;
import com.tecomerce.productservice.infrastructure.adapter.input.rest.service.dto.ProductDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.tecomerce.productservice.infrastructure.adapter.input.rest.mapper.ProductDTOMapper.PRODUCT_DTO_MAPPER;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/products")
@CrossOrigin(origins = "http://mic-productservice-production.up.railway.app/v1/**")
public class ProductController implements ProductApi {

    private  final ProductCrudUseCase productUseCase;

    @Override
    public ResponseEntity<List<ProductDTO>> getAll() {
        return new ResponseEntity<>(PRODUCT_DTO_MAPPER.toDTOs(productUseCase.findAll()), HttpStatus.OK);
    }
}
