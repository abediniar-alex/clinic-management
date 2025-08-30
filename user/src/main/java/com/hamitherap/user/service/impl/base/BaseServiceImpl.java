package com.hamitherap.user.service.impl.base;

import com.hamitherap.user.service.base.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class BaseServiceImpl<E, D, R> implements BaseService<E, D, R> {
    protected final JpaRepository<E, Long> repository;

    protected BaseServiceImpl(JpaRepository<E, Long> repository) {
        this.repository = repository;
    }
}
