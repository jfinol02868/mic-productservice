package com.tecomerce.productservice.infrastructure.adapter.input.rest;

import com.tecomerce.productservice.application.ports.input.ProductCrudUseCase;
import com.tecomerce.productservice.infrastructure.adapter.input.rest.mapper.ProductDTOMapper;
import com.tecomerce.productservice.infrastructure.adapter.input.rest.service.ProductApi;
import com.tecomerce.productservice.infrastructure.adapter.input.rest.service.dto.ProductDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Tag(name = "Products")
@RequestMapping("/v1/products")
@CrossOrigin(origins = {"http://localhost:3000", "https://mic-productservice-production.up.railway.app"})
public class ProductController implements ProductApi {

    private final ProductDTOMapper mapper;
    private  final ProductCrudUseCase productUseCase;

    public ProductController(ProductCrudUseCase productUseCase, ProductDTOMapper mapper) {
        this.productUseCase = productUseCase;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<List<ProductDTO>> findAll() {
        return new ResponseEntity<>(mapper.toDTOList(productUseCase.findAll()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductDTO> create(ProductDTO productDTO) {
        return new ResponseEntity<>(mapper.toDTO(productUseCase.save(
                mapper.toModel(productDTO))),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ProductDTO> findById(String id) {
        return new ResponseEntity<>(mapper.toDTO(
                productUseCase.findById(id)),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductDTO> update(ProductDTO productDTO, String id) {
        return new ResponseEntity<>(mapper.toDTO(
                productUseCase.update(id, mapper.toModel(productDTO))),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        productUseCase.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
