package com.tecomerce.productservice.application.usercase;

import com.tecomerce.productservice.application.ports.input.CampaignCRUDUserCase;
import com.tecomerce.productservice.application.ports.output.CampaignPersistence;
import com.tecomerce.productservice.domain.exception.EntityNotFoundException;
import com.tecomerce.productservice.domain.model.Campaign;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignCRUDUserCaseImpl implements CampaignCRUDUserCase {

    private final CampaignPersistence persistence;

    public CampaignCRUDUserCaseImpl(CampaignPersistence persistence) {
        this.persistence = persistence;
    }

    @Override
    public Campaign findById(String id) {
        return persistence.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Campaign> findAll() {
        return persistence.findAll();
    }

    @Override
    public Campaign save(Campaign value) {
        return persistence.save(value);
    }

    @Override
    public Campaign update(String id, Campaign value) {
       return persistence.findById(id).map(c -> {
           c.setId(c.getId());
           c.setName(value.getName());
           c.setDescription(value.getDescription());
           c.setTenant(value.getTenant());
           c.setStartDate(value.getStartDate());
           c.setEndDate(value.getEndDate());
           return persistence.save(c);
        }).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void deleteById(String id) {
        persistence.findById(id).ifPresentOrElse( c -> {
            persistence.deleteById(c.getId());
        }, () -> { throw new EntityNotFoundException(); });
    }
}
