package com.solutionsone.mic.productservice.infrastructure.bd.postgres.repository.impl;

import com.solutionsone.mic.productservice.domain.entity.Brand;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
    @DisplayName("Create brand")
    void  createTest() {

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
    @DisplayName("Create all brands")
    void createAllTest() {

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
    @DisplayName("Update brand")
    void updateTest() {
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
    @DisplayName("Find brand by id.")
    void findByIdTest() {
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
        // Simula las conversiones y la búsqueda en el repositorio
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
    @DisplayName("Find brands by ids")
    void findByIdsTest() {
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
    @DisplayName("Delete all brands by ids")
    void deleteAllTest() {
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
    @DisplayName("Find all brands paginated")
    void findAllPaginatedTest() {
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
    @DisplayName("Filter brands with pagination and sorting")
    void filtersTest() {
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

}
