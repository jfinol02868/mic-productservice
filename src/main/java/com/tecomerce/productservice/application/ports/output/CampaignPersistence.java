package com.tecomerce.productservice.application.ports.output;

import com.tecomerce.productservice.domain.model.Campaign;

import java.util.List;
import java.util.Optional;

public interface CampaignPersistence {

    Optional<Campaign> findById(String id);

    List<Campaign> findAll();

    Campaign save(Campaign campaign);

    void deleteById(String id);
}
