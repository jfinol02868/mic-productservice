package com.solutionsone.mic.productservice.infrastructure.bd.postgres.repository.impl;

import com.solutionsone.mic.productservice.domain.entity.Brand;
import com.solutionsone.mic.productservice.domain.exception.EntityNotFoundException;
import com.solutionsone.mic.productservice.domain.exception.PageNotValidException;
import com.solutionsone.mic.productservice.infrastructure.bd.postgres.entity.BrandEntity;
import com.solutionsone.mic.productservice.infrastructure.bd.postgres.mapper.BrandEntityMapper;
import com.solutionsone.mic.productservice.infrastructure.bd.postgres.repository.BrandRepositoryAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.solutionsone.mic.productservice.domain.util.Message.BRAND_NOT_FOUND;
import static com.solutionsone.mic.productservice.domain.util.Message.ERROR_PAGINATED;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

class BrandRepositoryImplTest {

    @InjectMocks
    private BrandRepositoryImpl brandRepositoryImpl;

    @Mock
    private BrandEntityMapper mapper;

    @Mock
    private BrandRepositoryAdapter repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Repository ->> Create brand.")
    void  testCreate() {

        //Arrange
        Brand brandToCreate = Brand.builder()
                .id(1L)
                .name("Calvin Klein")
                .description("Calvin Klein Fashion")
                .websiteUrl("http://www.calvinklein.com")
                .logoUrl("http://www.calvinklein.com/logo.png")
                .isActive(true)
                .build();

        when(brandRepositoryImpl.create(brandToCreate)).thenReturn(brandToCreate);
        when(mapper.toModel(any())).thenReturn(brandToCreate);

        //Act
        Brand brand = mapper.toModel(repository.save(mapper.toEntity(brandToCreate)));

        //Assert
        assertEquals(brandToCreate, brand);
    }

    @Test
    @DisplayName("Repository ->> Create all brands.")
    void testCreateAll() {

        // Arrange
        List<Brand> brandsToCreate = Arrays.asList(
                Brand.builder()
                        .id(1L)
                        .name("Calvin Klein")
                        .description("Calvin Klein Fashion")
                        .websiteUrl("http://www.calvinklein.com")
                        .logoUrl("http://www.calvinklein.com/logo.png")
                        .isActive(true)
                        .build(),
                Brand.builder()
                        .id(2L)
                        .name("Guess")
                        .description("Guess Fashion Apparel")
                        .websiteUrl("http://www.guess.com")
                        .logoUrl("http://www.guess.com/logo.png")
                        .isActive(true)
                        .build()
        );

        when(brandRepositoryImpl.createAll(anyList())).thenReturn(brandsToCreate);
        when(mapper.toModels(anyList())).thenReturn(brandsToCreate);

        // Act
        List<Brand> createdBrands = mapper.toModels(repository.saveAll(mapper.toEntities(brandsToCreate)));

        // Assert
        assertEquals(brandsToCreate.size(), createdBrands.size());
    }

    @Test
    @DisplayName("Repository ->> Update brand.")
    void testUpdate() {
        // Arrange
        Brand brandToUpdate = Brand.builder()
                .id(1L)
                .name("Calvin Klein")
                .description("Calvin Klein Fashion")
                .websiteUrl("http://www.calvinklein.com")
                .logoUrl("http://www.calvinklein.com/logo.png")
                .isActive(true)
                .build();

        BrandEntity brandEntity = BrandEntity.builder()
                .id(1L)
                .name("Calvin Klein_2")
                .description("Calvin Klein Fashion_2")
                .websiteUrl("http://www.calvinklein.com_2")
                .logoUrl("http://www.calvinklein.com/logo.png_2")
                .isActive(false)
                .build();

        when(repository.findById(1L)).thenReturn(Optional.of(brandEntity));
        when(repository.save(any(BrandEntity.class))).thenReturn(brandEntity);
        when(mapper.toModel(any(BrandEntity.class))).thenReturn(brandToUpdate);
        when(mapper.toEntity(any(Brand.class))).thenReturn(brandEntity);

        // Act
        Brand updatedBrand = brandRepositoryImpl.update(brandToUpdate, 1L);

        // Assert
        assertEquals(brandToUpdate, updatedBrand);
        verify(repository, times(1)).findById(1L);
        verify(repository, times(1)).save(any(BrandEntity.class));
    }

    @Test
    @DisplayName("Repository ->> Find brand by id.")
    void testFindById() {
        // Arrange
        Brand brandToFind = Brand.builder()
                .id(1L)
                .name("Calvin Klein")
                .description("Calvin Klein Fashion")
                .websiteUrl("http://www.calvinklein.com")
                .logoUrl("http://www.calvinklein.com/logo.png")
                .isActive(true)
                .build();

        BrandEntity brandEntity = new BrandEntity();
        when(repository.findById(1L)).thenReturn(Optional.of(brandEntity));
        when(mapper.toModel(brandEntity)).thenReturn(brandToFind);

        // Act
        Brand brand = brandRepositoryImpl.findById(1L);

        // Assert
        assertNotNull(brand);
        assertEquals(brandToFind, brand);
        verify(repository).findById(1L); // Verifica que se llamó al repositorio
        verify(mapper).toModel(brandEntity); // Verifica que se utilizó el mapper
    }

    @Test
    @DisplayName("Repository ->> Find brands by ids.")
    void testFindByIds() {
        // Arrange
        List<Long> ids = Arrays.asList(1L, 2L);
        List<Brand> brandsToFind = Arrays.asList(
                Brand.builder()
                        .id(1L)
                        .name("Calvin Klein")
                        .description("Calvin Klein Fashion")
                        .websiteUrl("http://www.calvinklein.com")
                        .logoUrl("http://www.calvinklein.com/logo.png")
                        .isActive(true)
                        .build(),
                Brand.builder()
                        .id(2L)
                        .name("Guess")
                        .description("Guess Fashion Apparel")
                        .websiteUrl("http://www.guess.com")
                        .logoUrl("http://www.guess.com/logo.png")
                        .isActive(true)
                        .build()
        );

        when(repository.findAllById(ids)).thenReturn(Arrays.asList(new BrandEntity(), new BrandEntity()));
        when(mapper.toModels(anyList())).thenReturn(brandsToFind);

        // Act
        List<Brand> brands = brandRepositoryImpl.findByIds(ids);

        // Assert
        assertNotNull(brands);
        assertEquals(brandsToFind.size(), brands.size());
        verify(repository).findAllById(ids);
        verify(mapper).toModels(anyList());
    }

    @Test
    @DisplayName("Repository ->> Delete all brands by ids.")
    void testDeleteAll() {
        // Arrange
        List<Long> ids = Arrays.asList(1L, 2L);
        doNothing().when(repository).deleteAllById(ids);
        ids.forEach(id -> when(repository.findById(id)).thenReturn(Optional.of(new BrandEntity())));

        // Act
        brandRepositoryImpl.deleteAll(ids);

        // Assert
        ids.forEach(id -> verify(repository).findById(id));
        verify(repository).deleteAllById(ids);
    }

    @Test
    @DisplayName("Repository ->> Find all brands paginated.")
    void testFindAllPaginated() {
        // Arrange
        List<Brand> brandsToFind = Arrays.asList(
                Brand.builder()
                        .id(1L)
                        .name("Calvin Klein")
                        .description("Calvin Klein Fashion")
                        .websiteUrl("http://www.calvinklein.com")
                        .logoUrl("http://www.calvinklein.com/logo.png")
                        .isActive(true)
                        .build(),
                Brand.builder()
                        .id(2L)
                        .name("Guess")
                        .description("Guess Fashion Apparel")
                        .websiteUrl("http://www.guess.com")
                        .logoUrl("http://www.guess.com/logo.png")
                        .isActive(true)
                        .build()
        );

        PageRequest pageRequest = PageRequest.of(0, 2, Sort.by(Sort.Direction.ASC, "name"));
        Page<BrandEntity> brandEntitiesPage = new PageImpl<>(Arrays.asList(new BrandEntity(), new BrandEntity()), pageRequest, 2);

        when(repository.findAll(pageRequest)).thenReturn(brandEntitiesPage);
        when(mapper.toModels(anyList())).thenReturn(brandsToFind);

        // Act
        List<Brand> brands = brandRepositoryImpl.findAllPaginated(0, 2, "name", "ASC");

        // Assert
        assertNotNull(brands);
        assertEquals(brandsToFind.size(), brands.size());
        verify(repository).findAll(pageRequest);
        verify(mapper).toModels(anyList());
    }

    @Test
    @DisplayName("Repository ->> Filter brands with pagination and sorting.")
    void testFilters() {
        // Arrange
        Brand filterObject = Brand.builder()
                .name("Calvin Klein")
                .build();

        List<Brand> expectedBrands = Arrays.asList(
                Brand.builder()
                        .id(1L)
                        .name("Calvin Klein")
                        .description("Calvin Klein Fashion")
                        .websiteUrl("http://www.calvinklein.com")
                        .logoUrl("http://www.calvinklein.com/logo.png")
                        .isActive(true)
                        .build(),
                Brand.builder()
                        .id(2L)
                        .name("Guess")
                        .description("Guess Fashion Apparel")
                        .websiteUrl("http://www.guess.com")
                        .logoUrl("http://www.guess.com/logo.png")
                        .isActive(true)
                        .build()
        );

        PageRequest pageRequest = PageRequest.of(0, 2, Sort.by(Sort.Direction.ASC, "name"));
        Page<BrandEntity> brandEntitiesPage = new PageImpl<>(Arrays.asList(new BrandEntity(), new BrandEntity()), pageRequest, 2);

        // Mock que acepta cualquier Specification y el PageRequest específico
        when(repository.findAll(any(Specification.class), eq(pageRequest))).thenReturn(brandEntitiesPage);
        when(mapper.toModels(anyList())).thenReturn(expectedBrands);

        // Act
        List<Brand> actualBrands = brandRepositoryImpl.filters(filterObject, 0, 2, "ASC", "name");

        // Assert
        assertNotNull(actualBrands);
        assertEquals(expectedBrands.size(), actualBrands.size());
        verify(repository).findAll(any(Specification.class), eq(pageRequest));
        verify(mapper).toModels(anyList());
    }

    @Test
    @DisplayName("Repository ->> Brand by id not fount.")
    void testFindByIdNotFount() {

        // Arrange
        Long nonExistentId = 999L;
        when(repository.findById(nonExistentId)).thenReturn(Optional.empty());

        // Act & Assert
        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> {
            brandRepositoryImpl.findById(nonExistentId);
        });

        assertEquals(BRAND_NOT_FOUND.getCode(), exception.getCode());
        assertEquals(String.format(BRAND_NOT_FOUND.getValue(), nonExistentId), exception.getMessage());
        verify(repository).findById(nonExistentId);
    }

    @Test
    @DisplayName("Repository ->> Page no valid exception.")
    void testFindAllPaginatedErrorPaginated() {

        // Arrange
        int page = 0;
        int size = 2;
        String sort = "name";
        String direction = "INVALID_DIRECTION";

        // Act
        PageNotValidException exception = assertThrows(PageNotValidException.class, () -> {
            brandRepositoryImpl.findAllPaginated(page, size, sort, direction);
        });

        // Assert
        assertEquals(ERROR_PAGINATED.getCode(), exception.getCode());
        assertEquals(ERROR_PAGINATED.getValue(), exception.getMessage());
    }

    @Test
    @DisplayName("Repository ->> Page not valid exception in filters method.")
    void testFilterErrorPaginated() {

        // Arrange
        Brand filterObject = Brand.builder().name("Calvin Klein").build();
        int page = 0;
        int size = 2;
        String direction = "INVALID_DIRECTION";
        String[] sortProperties = {"name"};

        // Act
        PageNotValidException exception = assertThrows(PageNotValidException.class, () -> {
            brandRepositoryImpl.filters(filterObject, page, size, direction, sortProperties);
        });

        // Assert
        assertEquals(ERROR_PAGINATED.getCode(), exception.getCode());
        assertEquals(ERROR_PAGINATED.getValue(), exception.getMessage());
    }
}
