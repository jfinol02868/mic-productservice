package com.tecomerce.productservice.application.ports.output;

import com.tecomerce.productservice.domain.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryPersistence {

    Optional<Category> findById(String id);

    List<Category> findAll();

    Category save(Category category);

    void deleteById(String id);
}
