package com.hamitherap.user.service.impl;

import com.hamitherap.user.domain.Specialization;
import com.hamitherap.user.dto.SpecializationDto;
import com.hamitherap.user.mapper.impl.SpecializationMapper;
import com.hamitherap.user.repository.PsychologistRepository;
import com.hamitherap.user.repository.SpecializationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpecializationService {
    private final SpecializationRepository specificationRepository;
    private final PsychologistRepository psychologistRepository;
    private final SpecializationMapper specificationMapper;

    public SpecializationDto createSpecialization(SpecializationDto dto) {
        if (specificationRepository.existsBySpecializationNameIgnoreCase(dto.getSpecializationName())) {
            throw new IllegalArgumentException("تخصص با عنوان " + dto.getSpecializationName() + " موجود است");
        }
        Specialization specialization = specificationMapper.toEntity(dto);
        Specialization saved = specificationRepository.save(specialization);
        return specificationMapper.toDto(saved);
    }

    public Page<SpecializationDto> getSpecializations(Pageable pageable) {
        return specificationRepository.findAll(pageable)
                .map(specificationMapper::toDto);
    }

    public SpecializationDto getSpecialization(Long id) {
        return specificationRepository
                .findById(id).map(specificationMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("تخصص پیدا نشد!"));
    }

    public SpecializationDto updateSpecialization(Long id, SpecializationDto dto) {
        Specialization existing = specificationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("تخصص پیدا نشد"));
        existing.setSpecializationName(dto.getSpecializationName());

        if (specificationRepository.existsBySpecializationNameIgnoreCase(existing.getSpecializationName()) &&
                !existing.getSpecializationName().equals(dto.getSpecializationName())) {
            throw new IllegalArgumentException("تخصص با عنوان " + dto.getSpecializationName() + " موجود است");
        }

        Specialization updated = specificationRepository.save(existing);
        return specificationMapper.toDto(updated);
    }

    public void deleteSpecialization(Long id) {
        Specialization specialization = specificationRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("تخصص پیدا نشد"));

        if (psychologistRepository.existsBySpecializations_Id(id)) {
            throw new IllegalStateException("تخصص '" + specialization.getSpecializationName() + "' برای یک یا چند درمانگر استفاده شده و امکان حذف آن نیست");
        }

        specificationRepository.deleteById(id);
    }
}
