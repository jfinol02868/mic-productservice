package com.tecomerce.productservice.application.ports.input;

import java.util.List;

public interface BaseCRUDUseCase<T> {

    default T findById(String id){ return null;}
    default List<T> findAll(){ return null;}
    default T save(T value) { return null;};
    default T update(String id, T value) { return null;};
    default  void deleteById(String id){ };
}
