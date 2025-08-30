package com.hamitherap.user.controller;

import com.hamitherap.user.dto.SpecializationDto;
import com.hamitherap.user.service.impl.SpecializationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/specializations")
@RequiredArgsConstructor
public class SpecializationController {
    private final SpecializationService specializationService;

    @PostMapping
    public SpecializationDto create(@RequestBody @Valid SpecializationDto dto) {
        return specializationService.createSpecialization(dto);
    }

    @GetMapping
    public Page<SpecializationDto> getSpecializations(Pageable pageable) {
        return specializationService.getSpecializations(pageable);
    }

    @GetMapping("/{id}")
    public SpecializationDto getSpecialization(@PathVariable Long id) {
        return specializationService.getSpecialization(id);
    }

    @PutMapping("/{id}")
    public SpecializationDto update(@PathVariable Long id, @RequestBody @Valid SpecializationDto dto) {
        return specializationService.updateSpecialization(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteSpecialization(@PathVariable Long id) {
        specializationService.deleteSpecialization(id);
    }
}
