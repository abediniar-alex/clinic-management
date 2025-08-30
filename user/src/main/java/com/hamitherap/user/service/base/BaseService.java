package com.hamitherap.user.service.base;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Reusable service interface
 */
public interface BaseService<E, D, R> {
    D Create(@Valid R request);

    Page<D> findAll(Pageable pageable);

    D getById(Long id);

    D update(@Valid R request);

    void deleteById(Long id);
}
