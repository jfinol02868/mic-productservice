package com.tecomerce.productservice.infrastructure.adapter.input.rest.mapper;

import com.tecomerce.productservice.domain.model.Campaign;
import com.tecomerce.productservice.infrastructure.adapter.input.rest.service.dto.CampaignDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper( componentModel = "spring")
public interface CampaignDTOMapper {

    CampaignDTO toDTO(Campaign campaign);

    Campaign toModel(CampaignDTO campaignDTO);

    List<CampaignDTO> toDTOList(List<Campaign> campaigns);

    List<Campaign> toModelList(List<CampaignDTO> campaignDTOs);
}
