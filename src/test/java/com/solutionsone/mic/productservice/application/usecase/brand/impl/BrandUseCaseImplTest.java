package com.solutionsone.mic.productservice.application.usecase.brand.impl;

import com.solutionsone.mic.productservice.domain.entity.Brand;
import com.solutionsone.mic.productservice.domain.repository.BrandRepository;
import com.solutionsone.mic.productservice.domain.util.MapperUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class BrandUseCaseImplTest {

    @Mock
    private MapperUtil mapperUtil;
    @Mock
    private BrandRepository repository;
    @InjectMocks
    private BrandUseCaseImpl brandUseCaseImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("UserCase ->> Create brand.")
    void testCreate() {

        //Arrange
        Brand brandToCreate = Brand.builder()
                .id(1L)
                .name("Calvin Klein")
                .description("Calvin Klein Fashion")
                .websiteUrl("http://www.calvinklein.com")
                .logoUrl("http://www.calvinklein.com/logo.png")
                .isActive(true)
                .build();


        when(repository.create(brandToCreate)).thenReturn(brandToCreate);

        // Act
        Brand result = brandUseCaseImpl.create(brandToCreate);

        // Assert
        assertNotNull(result);
        assertEquals(brandToCreate, result);
        verify(repository, times(1)).create(brandToCreate);
    }

    @Test
    @DisplayName("UserCase ->> Create all brands.")
    void testCreteAll() {

        // Arrange
        List<Brand> brands = List.of(
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
                        .name("Nike")
                        .description("Nike Fashion")
                        .websiteUrl("http://www.nike.com")
                        .logoUrl("http://www.nike.com/logo.png")
                        .isActive(true)
                        .build()
        );

        when(repository.createAll(anyList())).thenReturn(brands);

        // Act
        List<Brand> brandList = brandUseCaseImpl.createAll(brands);

        // Assert
        assertNotNull(brandList);
        assertEquals(brands, brandList);
        verify(repository, times(1)).createAll(brands);
    }

    @Test
    @DisplayName("UserCase ->> Update brand.")
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


        when(repository.update(brandToUpdate, 1L)).thenReturn(brandToUpdate);

        // Act
        Brand result = brandUseCaseImpl.update(brandToUpdate, 1L);

        // Assert
        assertNotNull(result);
        assertEquals(brandToUpdate, result);
        verify(repository, times(1)).update(brandToUpdate, 1L);
    }

    @Test
    @DisplayName("UserCase ->> Update all brands.")
    void testUpdateAll() {

        // Arrange
        List<Brand> brands = List.of(
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
                        .name("Nike")
                        .description("Nike Fashion")
                        .websiteUrl("http://www.nike.com")
                        .logoUrl("http://www.nike.com/logo.png")
                        .isActive(true)
                        .build()
        );

        when(repository.updateAll(anyList())).thenReturn(brands);

        // Act
        List<Brand> brandList = brandUseCaseImpl.updateAll(brands);

        //Assert
        assertNotNull(brandList);
        assertEquals(brands, brandList);
        verify(repository, times(1)).updateAll(brands);
    }

    @Test
    @DisplayName("UserCase ->> Find brand by id.")
    void testFindById() {

        //Arrange
        Brand brandToFind = Brand.builder()
                .id(1L)
                .name("Calvin Klein")
                .description("Calvin Klein Fashion")
                .websiteUrl("http://www.calvinklein.com")
                .logoUrl("http://www.calvinklein.com/logo.png")
                .isActive(true)
                .build();

        when(repository.findById(anyLong())).thenReturn(brandToFind);

        // Act
        Brand result = brandUseCaseImpl.findById(1L);

        // Assert
        assertNotNull(result);
        assertEquals(brandToFind, result);
        verify(repository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("UserCase ->> Find all brands by ids.")
    void testFindByIds() {

        // Arrange
        List<Brand> brands = List.of(
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
                        .name("Nike")
                        .description("Nike Fashion")
                        .websiteUrl("http://www.nike.com")
                        .logoUrl("http://www.nike.com/logo.png")
                        .isActive(true)
                        .build()
        );

        when(repository.findByIds(anyList())).thenReturn(brands);

        // Act
        List<Brand> brandList = brandUseCaseImpl.findByIds(List.of(1L, 2L));

        // Assert
        assertNotNull(brandList);
        assertEquals(brands, brandList);
        verify(repository, times(1)).findByIds(List.of(1L, 2L));
    }

    @Test
    @DisplayName("UserCase ->> Delete brand by id.")
    void testDeleteById() {

            // Arrange
            doNothing().when(repository).delete(anyLong());

            // Act
            brandUseCaseImpl.delete(1L);

            // Assert
            verify(repository, times(1)).delete(1L);
    }

    @Test
    @DisplayName("UserCase ->> Delete all brands by ids.")
    void testDeleteAll() {

            // Arrange
            doNothing().when(repository).deleteAll(anyList());

            // Act
            brandUseCaseImpl.deleteAll(List.of(1L, 2L));

            // Assert
            verify(repository, times(1)).deleteAll(List.of(1L, 2L));
    }

    @Test
    @DisplayName("UserCase ->> Find all brands paginated.")
    void testFindAllPaginated() {
        // Arrange
        List<Brand> brands = List.of(
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
                        .name("Nike")
                        .description("Nike Fashion")
                        .websiteUrl("http://www.nike.com")
                        .logoUrl("http://www.nike.com/logo.png")
                        .isActive(true)
                        .build()
        );

        when(repository.findAllPaginated(1, 10, "name", "asc")).thenReturn(brands);

        // Act
        List<Brand> brandList = brandUseCaseImpl.findAllPaginated(1, 10, "name", "asc");

        // Assert
        assertNotNull(brandList);
        assertEquals(brands, brandList);
        verify(repository, times(1)).findAllPaginated(1, 10, "name", "asc");
    }

    @Test
    @DisplayName("UserCase ->> Filter brands with pagination and sorting.")
    void testFilters() {

        // Arrange
        String filterProperties = "{\"name\":\"Calvin Klein\"}";
        Brand brandFilter = Brand.builder()
                .name("Calvin Klein")
                .build();
        List<Brand> filteredBrands = List.of(
                Brand.builder()
                        .id(1L)
                        .name("Calvin Klein")
                        .description("Calvin Klein Fashion")
                        .websiteUrl("http://www.calvinklein.com")
                        .logoUrl("http://www.calvinklein.com/logo.png")
                        .isActive(true)
                        .build()
        );

        when(mapperUtil.mappingEntity(filterProperties, Brand.class)).thenReturn(brandFilter);
        when(repository.filters(brandFilter, 1, 10, "asc", "name")).thenReturn(filteredBrands);

        // Act
        List<Brand> result = brandUseCaseImpl.filters(filterProperties, 1, 10, "asc", "name");

        // Assert
        assertNotNull(result);
        assertEquals(filteredBrands, result);
        verify(mapperUtil, times(1)).mappingEntity(filterProperties, Brand.class);
        verify(repository, times(1)).filters(brandFilter, 1, 10, "asc", "name");
    }
}
