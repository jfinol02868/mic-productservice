package com.tecomerce.productservice.infrastructure.adapter.input.rest;

import com.tecomerce.productservice.infrastructure.adapter.input.rest.service.CampaignApi;
import com.tecomerce.productservice.infrastructure.adapter.input.rest.service.dto.CampaignDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Campaigns")
@RequestMapping("/v1/campaigns")
public class CampaignController implements CampaignApi {

    @Override
    public ResponseEntity<CampaignDTO> create(CampaignDTO campaignDTO) {
        return CampaignApi.super.create(campaignDTO);
    }

    @Override
    public ResponseEntity<CampaignDTO> findById(String id) {
        return CampaignApi.super.findById(id);
    }

    @Override
    public ResponseEntity<List<CampaignDTO>> findAll() {
        return CampaignApi.super.findAll();
    }

    @Override
    public ResponseEntity<CampaignDTO> update(CampaignDTO campaignDTO, String id) {
        return CampaignApi.super.update(campaignDTO, id);
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        return CampaignApi.super.delete(id);
    }
}
