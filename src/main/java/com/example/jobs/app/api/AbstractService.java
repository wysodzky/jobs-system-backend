package com.example.jobs.app.api;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AbstractService<T> {
    List<T> findAll();
    T save(T entity);
    T findById(Long id);
    void delete(T entity);
    void deleteById(Long id);
}
