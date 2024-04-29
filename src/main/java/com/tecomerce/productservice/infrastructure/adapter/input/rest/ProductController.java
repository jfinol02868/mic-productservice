package com.tecomerce.productservice.infrastructure.adapter.input.rest;

import com.tecomerce.productservice.application.ports.input.ProductCrudUseCase;
import com.tecomerce.productservice.infrastructure.adapter.input.rest.service.ProductApi;
import com.tecomerce.productservice.infrastructure.adapter.input.rest.service.dto.ProductDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.tecomerce.productservice.infrastructure.adapter.input.rest.mapper.ProductDTOMapper.PRODUCT_DTO_MAPPER;

@Tag(name = "Products")
@RestController
@AllArgsConstructor
@RequestMapping("/v1/products")
public class ProductController implements ProductApi {

    private  final ProductCrudUseCase productUseCase;

    @Override
    public ResponseEntity<List<ProductDTO>> findAll() {
        return new ResponseEntity<>(PRODUCT_DTO_MAPPER.toDTOs(productUseCase.findAll()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductDTO> create(ProductDTO productDTO) {
        return new ResponseEntity<>(PRODUCT_DTO_MAPPER.toDTO(productUseCase.save(
                PRODUCT_DTO_MAPPER.toModel(productDTO))),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ProductDTO> findById(String id) {
        return new ResponseEntity<>(PRODUCT_DTO_MAPPER.toDTO(
                productUseCase.findById(id)),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductDTO> update(ProductDTO productDTO, String id) {
        return new ResponseEntity<>(PRODUCT_DTO_MAPPER.toDTO(
                productUseCase.update(id, PRODUCT_DTO_MAPPER.toModel(productDTO))),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        return new ResponseEntity<>(productUseCase.deleteById(id), HttpStatus.NO_CONTENT);
    }
}
