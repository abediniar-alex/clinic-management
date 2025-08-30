package com.hamitherap.user.service;

import com.hamitherap.user.dto.PsychologistDto;
import com.hamitherap.user.dto.PsychologistRequest;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PsychologistService {
    PsychologistDto create(PsychologistRequest request);

    Page<PsychologistDto> getPsychologists(Pageable pageable);

    PsychologistDto getPsychologist(Long id);

    PsychologistDto update(Long id, @Valid PsychologistRequest request);

    void delete(Long id);
}
