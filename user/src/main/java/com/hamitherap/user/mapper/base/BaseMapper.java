package com.hamitherap.user.mapper.base;

import org.mapstruct.MappingTarget;

import java.util.List;

public interface BaseMapper<E, D, R> {
    D toDto(E entity);

    List<D> toDtoList(List<E> entities);

    E requestToEntity(R request);

    E toEntity(D dto);

    void updateFromRequest(@MappingTarget E entity, R request);
}
