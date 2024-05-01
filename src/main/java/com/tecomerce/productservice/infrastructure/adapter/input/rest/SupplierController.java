package com.tecomerce.productservice.infrastructure.adapter.input.rest;

import com.tecomerce.productservice.application.ports.input.SupplierCrudUseCase;
import com.tecomerce.productservice.infrastructure.adapter.input.rest.mapper.SupplierDTOMapper;
import com.tecomerce.productservice.infrastructure.adapter.input.rest.service.SupplierApi;
import com.tecomerce.productservice.infrastructure.adapter.input.rest.service.dto.SupplierDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Suppliers")
@RequestMapping("/v1/suppliers")
@CrossOrigin(origins = "http://localhost:3000/")
public class SupplierController implements SupplierApi {

    private final SupplierCrudUseCase useCase;
    private final SupplierDTOMapper mapper;

    public SupplierController(SupplierCrudUseCase useCase, SupplierDTOMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<SupplierDTO> create(SupplierDTO supplierDTO) {
        return new ResponseEntity<>(mapper.toDTO(useCase.save(mapper.toModel(supplierDTO))), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<SupplierDTO> findById(String id) {
        return new ResponseEntity<>(mapper.toDTO(useCase.findById(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<SupplierDTO>> findAll() {
        return new ResponseEntity<>(mapper.toDTOList(useCase.findAll()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SupplierDTO> update(SupplierDTO supplierDTO, String id) {
        return new ResponseEntity<>(mapper.toDTO(useCase.update(id, mapper.toModel(supplierDTO))), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        useCase.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
