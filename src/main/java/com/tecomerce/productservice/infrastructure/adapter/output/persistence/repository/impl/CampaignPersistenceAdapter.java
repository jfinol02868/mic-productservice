package com.tecomerce.productservice.infrastructure.adapter.output.persistence.repository.impl;

import com.tecomerce.productservice.application.ports.output.CampaignPersistence;
import com.tecomerce.productservice.domain.model.Campaign;
import com.tecomerce.productservice.infrastructure.adapter.output.persistence.mapper.CampaignEntityMapper;
import com.tecomerce.productservice.infrastructure.adapter.output.persistence.repository.CampaignRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CampaignPersistenceAdapter implements CampaignPersistence {

    private final CampaignRepository repository;
    private final CampaignEntityMapper mapper;

    public CampaignPersistenceAdapter(CampaignRepository repository, CampaignEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Campaign> findById(String id) {
        return repository.findById(id).map(mapper::toModel);
    }

    @Override
    public List<Campaign> findAll() {
        return repository.findAll().stream().map(mapper::toModel).toList();
    }

    @Override
    public Campaign save(Campaign campaign) {
        return mapper.toModel(repository.save(mapper.toEntity(campaign)));
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
