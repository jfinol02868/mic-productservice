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

import static com.solutionsone.mic.productservice.domain.util.Message.BRAND_NOT_FOUND;
import static com.solutionsone.mic.productservice.domain.util.Message.ERROR_PAGINATED;

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
        Brand brandEntity = this.findById(id);
        entity.setId(id);
        BeanUtils.copyProperties(entity, brandEntity);
        return mapper.toModel(repository.save(mapper.toEntity(brandEntity)));

    }

    @Override
    @Transactional(rollbackOn = PersistErrorException.class)
    public List<Brand> updateAll(List<Brand> entities) {
        entities.forEach(brand -> this.findById(brand.getId()));
        return mapper.toModels(repository.saveAll(mapper.toEntities(entities)));
    }

    @Override
    public Brand findById(Long id) {
        return mapper.toModel(repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(BRAND_NOT_FOUND.getCode(),
                        String.format(BRAND_NOT_FOUND.getValue(), id))));
    }

    @Override
    @Transactional(rollbackOn = PersistErrorException.class)
    public List<Brand> findByIds(List<Long> ids) {
        ids.forEach(this::findById);
        return mapper.toModels(repository.findAllById(ids));
    }

    @Override
    public void delete(Long id) {
        this.findById(id);
        repository.deleteById(id);
    }

    @Override
    @Transactional(rollbackOn = PersistErrorException.class)
    public void deleteAll(List<Long> ids) {
        ids.forEach(this::findById);
        repository.deleteAllById(ids);
    }

    @Override
    public List<Brand> findAllPaginated(int page, int size, String sort, String direction) {
        Pageable pageable;
        try {
            Sort.Direction dir = Sort.Direction.fromString(direction);
            pageable = PageRequest.of(page, size, Sort.by(dir, sort));
        } catch (IllegalArgumentException e) {
            throw new PageNotValidException(ERROR_PAGINATED.getCode(), ERROR_PAGINATED.getValue());
        }
        return mapper.toModels(repository.findAll(pageable).getContent());
    }

    @Override
    public List<Brand> filters(Brand object, int page, int size, String direction, String... sortProperties) {
        Pageable pageable;
        Specification<BrandEntity> spec = DynamicSpecification.byFields(object);
        try{
            Sort.Direction dir = Sort.Direction.fromString(direction);
            pageable = PageRequest.of(page, size, Sort.by(dir, sortProperties));
        }catch (IllegalArgumentException e){
            throw new PageNotValidException(ERROR_PAGINATED.getCode(),ERROR_PAGINATED.getValue());
        }
        return mapper.toModels(repository.findAll(spec, pageable).getContent());
    }
}
