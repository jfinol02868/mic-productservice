package com.tecomerce.productservice.infrastructure.adapter.output.persistence.mapper;

import com.tecomerce.productservice.domain.model.Campaign;
import com.tecomerce.productservice.infrastructure.adapter.output.persistence.entity.CampaignEntity;
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
public class CampaignEntityMapperImpl implements CampaignEntityMapper {

    @Override
    public CampaignEntity toEntity(Campaign campaign) {
        if ( campaign == null ) {
            return null;
        }

        CampaignEntity.CampaignEntityBuilder campaignEntity = CampaignEntity.builder();

        campaignEntity.id( campaign.getId() );
        campaignEntity.name( campaign.getName() );
        campaignEntity.description( campaign.getDescription() );
        campaignEntity.tenant( campaign.getTenant() );
        campaignEntity.startDate( campaign.getStartDate() );
        campaignEntity.endDate( campaign.getEndDate() );

        return campaignEntity.build();
    }

    @Override
    public Campaign toModel(CampaignEntity campaignEntity) {
        if ( campaignEntity == null ) {
            return null;
        }

        Campaign.CampaignBuilder campaign = Campaign.builder();

        campaign.id( campaignEntity.getId() );
        campaign.name( campaignEntity.getName() );
        campaign.description( campaignEntity.getDescription() );
        campaign.tenant( campaignEntity.getTenant() );
        campaign.startDate( campaignEntity.getStartDate() );
        campaign.endDate( campaignEntity.getEndDate() );

        return campaign.build();
    }

    @Override
    public List<CampaignEntity> toEntityList(List<Campaign> campaigns) {
        if ( campaigns == null ) {
            return null;
        }

        List<CampaignEntity> list = new ArrayList<CampaignEntity>( campaigns.size() );
        for ( Campaign campaign : campaigns ) {
            list.add( toEntity( campaign ) );
        }

        return list;
    }

    @Override
    public List<Campaign> toModelList(List<CampaignEntity> campaignEntities) {
        if ( campaignEntities == null ) {
            return null;
        }

        List<Campaign> list = new ArrayList<Campaign>( campaignEntities.size() );
        for ( CampaignEntity campaignEntity : campaignEntities ) {
            list.add( toModel( campaignEntity ) );
        }

        return list;
    }
}
