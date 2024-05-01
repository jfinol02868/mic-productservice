package com.tecomerce.productservice.infrastructure.adapter.input.rest.mapper;

import com.tecomerce.productservice.domain.model.Campaign;
import com.tecomerce.productservice.infrastructure.adapter.input.rest.service.dto.CampaignDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-02T00:53:55+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Private Build)"
)
@Component
public class CampaignDTOMapperImpl implements CampaignDTOMapper {

    @Override
    public CampaignDTO toDTO(Campaign campaign) {
        if ( campaign == null ) {
            return null;
        }

        CampaignDTO.CampaignDTOBuilder campaignDTO = CampaignDTO.builder();

        campaignDTO.id( campaign.getId() );
        campaignDTO.name( campaign.getName() );
        campaignDTO.description( campaign.getDescription() );
        campaignDTO.tenant( campaign.getTenant() );
        campaignDTO.startDate( campaign.getStartDate() );
        campaignDTO.endDate( campaign.getEndDate() );

        return campaignDTO.build();
    }

    @Override
    public Campaign toModel(CampaignDTO campaignDTO) {
        if ( campaignDTO == null ) {
            return null;
        }

        Campaign.CampaignBuilder campaign = Campaign.builder();

        campaign.id( campaignDTO.getId() );
        campaign.name( campaignDTO.getName() );
        campaign.description( campaignDTO.getDescription() );
        campaign.tenant( campaignDTO.getTenant() );
        campaign.startDate( campaignDTO.getStartDate() );
        campaign.endDate( campaignDTO.getEndDate() );

        return campaign.build();
    }

    @Override
    public List<CampaignDTO> toDTOList(List<Campaign> campaigns) {
        if ( campaigns == null ) {
            return null;
        }

        List<CampaignDTO> list = new ArrayList<CampaignDTO>( campaigns.size() );
        for ( Campaign campaign : campaigns ) {
            list.add( toDTO( campaign ) );
        }

        return list;
    }

    @Override
    public List<Campaign> toModelList(List<CampaignDTO> campaignDTOs) {
        if ( campaignDTOs == null ) {
            return null;
        }

        List<Campaign> list = new ArrayList<Campaign>( campaignDTOs.size() );
        for ( CampaignDTO campaignDTO : campaignDTOs ) {
            list.add( toModel( campaignDTO ) );
        }

        return list;
    }
}
