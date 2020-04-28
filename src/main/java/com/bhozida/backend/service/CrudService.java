package com.bhozida.backend.service;

import java.util.List;

public interface CrudService<T, ID> {
    T findById(ID id);

    T addUpdate(T object);

    List<T> findAll();

    void delete(T object);

    void deleteById(ID id);

    boolean empty();

    List<T> getSimilarType(Long id);
}
