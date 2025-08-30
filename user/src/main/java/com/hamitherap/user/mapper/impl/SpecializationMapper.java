package com.hamitherap.user.mapper.impl;

import com.hamitherap.user.domain.Specialization;
import com.hamitherap.user.dto.SpecializationDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SpecializationMapper {
    SpecializationDto toDto(Specialization entity);
    List<SpecializationDto> toDtoList(List<Specialization> entities);
    Specialization toEntity(SpecializationDto dto);
}
