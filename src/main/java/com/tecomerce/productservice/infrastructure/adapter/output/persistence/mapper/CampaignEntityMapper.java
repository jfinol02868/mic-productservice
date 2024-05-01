package com.tecomerce.productservice.infrastructure.adapter.output.persistence.mapper;

import com.tecomerce.productservice.domain.model.Campaign;
import com.tecomerce.productservice.infrastructure.adapter.output.persistence.entity.CampaignEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CampaignEntityMapper {

    CampaignEntity toEntity(Campaign campaign);

    Campaign toModel(CampaignEntity campaignEntity);

    List<CampaignEntity> toEntityList(List<Campaign> campaigns);

    List<Campaign> toModelList(List<CampaignEntity> campaignEntities);
}
