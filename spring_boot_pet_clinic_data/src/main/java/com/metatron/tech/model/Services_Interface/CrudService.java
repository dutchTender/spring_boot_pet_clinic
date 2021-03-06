package com.metatron.tech.model.Services_Interface;

import java.util.Optional;
import java.util.Set;

public interface CrudService<T, Long> {
    Set<T> findAll();
    Optional<T > findById(Long id);
    T save(T object);
    void delete(T object);
    void deleteById(Long id);
}
