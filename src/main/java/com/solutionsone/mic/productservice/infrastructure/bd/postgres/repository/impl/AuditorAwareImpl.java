package com.solutionsone.mic.productservice.infrastructure.bd.postgres.repository.impl;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("auditorAware")
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
       return Optional.of("admin");
    }
}
