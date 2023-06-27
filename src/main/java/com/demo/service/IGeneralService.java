package com.demo.service;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    T save(T t);
    Iterable<T> findByName(String name);
    Long count();
    void remove(Long id);
}
