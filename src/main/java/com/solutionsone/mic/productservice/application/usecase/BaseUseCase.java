package com.solutionsone.mic.productservice.application.usecase;

import com.solutionsone.mic.productservice.domain.repository.BaseRepository;

import java.util.List;

public interface BaseUseCase<T, K> extends BaseRepository<T, K> {

    default List<T> filters(String filterProperties, int page, int size, String direction, String... sortProperties){return  List.of(); }
}
