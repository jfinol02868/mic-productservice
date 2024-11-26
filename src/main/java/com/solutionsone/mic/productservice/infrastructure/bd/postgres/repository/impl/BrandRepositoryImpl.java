package com.solutionsone.mic.productservice.infrastructure.bd.postgres.repository.impl;

import com.solutionsone.mic.productservice.domain.entity.Brand;
import com.solutionsone.mic.productservice.domain.exception.EntityNotFoundException;
import com.solutionsone.mic.productservice.domain.exception.PageNotValidException;
import com.solutionsone.mic.productservice.domain.exception.PersistErrorException;
import com.solutionsone.mic.productservice.domain.repository.BrandRepository;
import com.solutionsone.mic.productservice.infrastructure.bd.postgres.entity.BrandEntity;
import com.solutionsone.mic.productservice.infrastructure.bd.postgres.mapper.BrandEntityMapper;
import com.solutionsone.mic.productservice.infrastructure.bd.postgres.repository.BrandRepositoryAdapter;
import com.solutionsone.mic.productservice.infrastructure.bd.util.DynamicSpecification;
import com.solutionsone.mic.productservice.infrastructure.bd.util.IdGenerator;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.solutionsone.mic.productservice.domain.util.Message.ERROR_PAGINATED;
import static com.solutionsone.mic.productservice.domain.util.Message.BRAND_NOT_FOUND;

@Repository
@AllArgsConstructor
public class BrandRepositoryImpl implements BrandRepository {

    private final IdGenerator idGenerator;
    private final BrandEntityMapper mapper;
    private final BrandRepositoryAdapter repository;

    @Override
    public Brand create(Brand entity) {
        return mapper.toModel(repository.save(mapper.toEntity(entity)));
    }

    @Override
    @Transactional(rollbackOn = PersistErrorException.class)
    public List<Brand> createAll(List<Brand> entities) {
        return mapper.toModels(repository.saveAll(mapper.toEntities(entities)));
    }

    @Override
    public Brand update(Brand entity, Long id) {

        Optional<BrandEntity> brandEntity = repository.findById(id);

        return brandEntity.map(brand -> {
            BeanUtils.copyProperties(entity, brand);
            return mapper.toModel(repository.save(mapper.toEntity(entity)));
        }).orElseThrow(() ->
                new EntityNotFoundException(BRAND_NOT_FOUND.getCode() ,
                        String.format(BRAND_NOT_FOUND.getMessage(), id))
        );
    }

    @Override
    public List<Brand> updateAll(List<Brand> entities) {
        return mapper.toModels(repository.saveAll(mapper.toEntities(entities)));
    }

    @Override
    public Brand findById(Long id) {
        return mapper.toModel(repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(BRAND_NOT_FOUND.getCode(),
                        String.format(BRAND_NOT_FOUND.getMessage(), id))));
    }

    @Override
    public List<Brand> findByIds(List<Long> ids) {
        return mapper.toModels(repository.findAllById(ids));
    }

    @Override
    public void delete(Long id) {
        this.findById(id);
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll(List<Long> ids) {
        ids.forEach(this::findById);
        repository.deleteAllById(ids);
    }

    @Override
    public List<Brand> findAllPaginated(int page, int size, String sort, String direction) {
        Pageable pageable = null;
        Sort.Direction dir = Sort.Direction.fromString(direction);
        try{
            pageable = PageRequest.of(page, size, Sort.by(dir, sort));
        }catch (IllegalArgumentException e){
            throw new PageNotValidException(ERROR_PAGINATED.getCode(),ERROR_PAGINATED.getMessage());
        }
        return mapper.toModels(repository.findAll(pageable).getContent());
    }

    @Override
    public List<Brand> filters(Brand object, int page, int size, String direction, String... sortProperties) {
        Pageable pageable = null;
        Specification<BrandEntity> spec = DynamicSpecification.byFields(object);
        try{
            Sort.Direction dir = Sort.Direction.fromString(direction);
            pageable = PageRequest.of(page, size, Sort.by(dir, sortProperties));
        }catch (IllegalArgumentException e){
            throw new PageNotValidException(ERROR_PAGINATED.getCode(),ERROR_PAGINATED.getMessage());
        }
        return mapper.toModels(repository.findAll(spec, pageable).getContent());
    }
}
