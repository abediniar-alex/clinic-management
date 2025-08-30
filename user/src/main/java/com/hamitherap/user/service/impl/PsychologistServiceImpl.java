package com.hamitherap.user.service.impl;

import com.hamitherap.user.domain.Psychologist;
import com.hamitherap.user.domain.Specialization;
import com.hamitherap.user.dto.PsychologistDto;
import com.hamitherap.user.dto.PsychologistRequest;
import com.hamitherap.user.mapper.impl.PsychologistMapper;
import com.hamitherap.user.repository.PsychologistRepository;
import com.hamitherap.user.repository.SpecializationRepository;
import com.hamitherap.user.service.PsychologistService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.data.domain.Page;

@Service
@RequiredArgsConstructor
public class PsychologistServiceImpl implements PsychologistService {
    private final PsychologistRepository psychologistRepository;
    private final SpecializationRepository specializationRepository;
    private final PsychologistMapper psychologistMapper;

    @Override
    public PsychologistDto create(PsychologistRequest request) {
        Psychologist psychologist = psychologistMapper.toEntity(request);

        List<Specialization> specializations = specializationRepository.findAllById(request.getSpecializationIds());
        psychologist.setSpecializations(specializations);

        Psychologist saved = psychologistRepository.save(psychologist);
        return psychologistMapper.toDto(saved);
    }

    @Override
    public Page<PsychologistDto> getPsychologists(Pageable pageable) {
        Page<Psychologist> page = psychologistRepository.findAll(pageable);
        return page.map(psychologistMapper::toDto); // ✅ map each entity individually
    }

    @Override
    public PsychologistDto getPsychologist(Long id) {
        Psychologist psychologist = psychologistRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("درمانگر با شناسه مورد نظر یافت نشد"));
        return psychologistMapper.toDto(psychologist);
    }

    @Override
    public PsychologistDto update(Long id, @Valid PsychologistRequest request) {
        Psychologist psychologist = psychologistRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("درمانگر با شناسه مورد نظر یافت نشد"));

        psychologistMapper.updateFromRequest(psychologist, request);

        List<Specialization> specializations = specializationRepository.findAllById(request.getSpecializationIds());
        psychologist.setSpecializations(specializations);

        Psychologist updated = psychologistRepository.save(psychologist);
        return psychologistMapper.toDto(updated);
    }

    @Override
    public void delete(Long id) {
        if (!psychologistRepository.existsById(id)) {
            throw new EntityNotFoundException("درمانگر با شناسه مورد نظر یافت نشد");
        }
        psychologistRepository.deleteById(id);
    }
}
