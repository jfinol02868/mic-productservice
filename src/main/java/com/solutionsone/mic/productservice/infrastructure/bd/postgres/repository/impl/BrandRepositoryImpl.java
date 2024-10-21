package com.solutionsone.mic.productservice.infrastructure.bd.postgres.repository.impl;

import com.solutionsone.mic.productservice.domain.entity.Brand;
import com.solutionsone.mic.productservice.domain.exception.PageNotValidException;
import com.solutionsone.mic.productservice.domain.repository.BrandRepository;
import com.solutionsone.mic.productservice.infrastructure.bd.postgres.entity.BrandEntity;
import com.solutionsone.mic.productservice.infrastructure.bd.postgres.mapper.BrandEntityMapper;
import com.solutionsone.mic.productservice.infrastructure.bd.postgres.repository.BrandRepositoryAdapter;
import com.solutionsone.mic.productservice.infrastructure.bd.util.DynamicSpecification;
import com.solutionsone.mic.productservice.infrastructure.bd.util.IdGenerator;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.solutionsone.mic.productservice.domain.util.Message.ERROR_PAGINATED;

@Repository
@AllArgsConstructor
public class BrandRepositoryImpl implements BrandRepository {

    private final IdGenerator idGenerator;
    private final BrandEntityMapper mapper;
    private final BrandRepositoryAdapter repository;


    @Override
    public List<Brand> filters(Brand object, int page, int size, String direction, String... sortProperties) {
        Pageable pageable = null;
        Specification<BrandEntity> spec = DynamicSpecification.byFields(object);
        Sort.Direction dir = Sort.Direction.fromString(direction);
        try{
            pageable = PageRequest.of(page, size, Sort.by(dir, sortProperties));
        }catch (IllegalArgumentException e){
            throw new PageNotValidException(ERROR_PAGINATED.getCode(),ERROR_PAGINATED.getMessage());
        }
        return mapper.toModels(repository.findAll(spec, pageable).getContent());
    }
}
