package com.example.jobs.app.service;

import com.example.jobs.app.api.AbstractService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class AbstractServiceImpl<T> implements AbstractService<T> {

    private JpaRepository<T,Long> repository;

    public AbstractServiceImpl(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    public AbstractServiceImpl() {
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }


    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public T findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(T entity) {
        repository.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
