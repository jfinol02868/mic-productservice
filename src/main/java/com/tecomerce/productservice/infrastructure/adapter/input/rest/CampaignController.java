package com.tecomerce.productservice.infrastructure.adapter.input.rest;

import com.tecomerce.productservice.application.ports.input.CampaignCRUDUserCase;
import com.tecomerce.productservice.infrastructure.adapter.input.rest.mapper.CampaignDTOMapper;
import com.tecomerce.productservice.infrastructure.adapter.input.rest.service.CampaignApi;
import com.tecomerce.productservice.infrastructure.adapter.input.rest.service.dto.CampaignDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Campaigns")
@RequestMapping("/v1/campaigns")
public class CampaignController implements CampaignApi {

    private final CampaignCRUDUserCase userCase;
    private final CampaignDTOMapper mapper;

    public CampaignController(CampaignCRUDUserCase userCase, CampaignDTOMapper mapper) {
        this.userCase = userCase;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<CampaignDTO> create(CampaignDTO campaignDTO) {
        return new ResponseEntity<>(mapper.toDTO(userCase.save(mapper.toModel(campaignDTO))), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CampaignDTO> findById(String id) {
        return new ResponseEntity<>(mapper.toDTO(userCase.findById(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CampaignDTO>> findAll() {
        return new ResponseEntity<>(mapper.toDTOList(userCase.findAll()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CampaignDTO> update(CampaignDTO campaignDTO, String id) {
        return new ResponseEntity<>(mapper.toDTO(userCase.update(id, mapper.toModel(campaignDTO))), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        userCase.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
