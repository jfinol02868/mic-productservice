package com.tecomerce.productservice.infrastructure.adapter.input.rest;

import com.tecomerce.productservice.application.ports.input.AddressCrudUseCase;
import com.tecomerce.productservice.infrastructure.adapter.input.rest.mapper.AddressDTOMapper;
import com.tecomerce.productservice.infrastructure.adapter.input.rest.service.AddressApi;
import com.tecomerce.productservice.infrastructure.adapter.input.rest.service.dto.AddressDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Address")
@RequestMapping("/v1/address")
@CrossOrigin(origins = "http://localhost:3000/")
public class AddressController implements AddressApi {

    private final AddressDTOMapper mapper;
    private final AddressCrudUseCase useCase;

    public AddressController(AddressDTOMapper mapper, AddressCrudUseCase useCase) {
        this.mapper = mapper;
        this.useCase = useCase;
    }

    @Override
    public ResponseEntity<AddressDTO> create(AddressDTO addressDTO) {
        return new ResponseEntity<>(mapper.toDTO(useCase.save(mapper.toModel(addressDTO))), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<AddressDTO> findById(String id) {
        return new ResponseEntity<>(mapper.toDTO(useCase.findById(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<AddressDTO>> findAll() {
        return new ResponseEntity<>(mapper.toDTOList(useCase.findAll()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AddressDTO> update(AddressDTO addressDTO, String id) {
        return new ResponseEntity<>(mapper.toDTO(useCase.update(id, mapper.toModel(addressDTO))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        useCase.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
