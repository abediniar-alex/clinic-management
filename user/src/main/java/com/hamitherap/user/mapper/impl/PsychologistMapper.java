package com.hamitherap.user.mapper.impl;

import com.hamitherap.user.domain.Psychologist;
import com.hamitherap.user.domain.Specialization;
import com.hamitherap.user.dto.PsychologistDto;
import com.hamitherap.user.dto.PsychologistRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = SpecializationMapper.class)
public interface PsychologistMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "specializations", ignore = true)
    Psychologist toEntity(PsychologistRequest request);

    @Mapping(target = "specializations", source = "specializations")
    PsychologistDto toDto(Psychologist entity);

    List<PsychologistDto> toDtoList(List<Psychologist> entities);

    void updateFromRequest(@MappingTarget Psychologist entity, PsychologistRequest request);

    default Long map(Specialization specialization) {
        return specialization != null ? specialization.getId() : null;
    }
}
