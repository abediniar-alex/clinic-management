package com.hamitherap.user.controller;

import com.hamitherap.user.dto.PsychologistDto;
import com.hamitherap.user.dto.PsychologistRequest;
import com.hamitherap.user.service.PsychologistService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/psychologists")
@RequiredArgsConstructor
public class PsychologistController {
    private final PsychologistService psychologistService;

    @Operation(summary = "ثبت درمانگر جدید")
    @PostMapping
    public PsychologistDto create(@RequestBody @Valid PsychologistRequest request) {
        return psychologistService.create(request);
    }

    @Operation(summary = "دریافت فهرست درمانگرها")
    @GetMapping
    public Page<PsychologistDto> getPsychologists(Pageable pageable) {
        return psychologistService.getPsychologists(pageable);
    }

    @Operation(summary = "دریافت اطلاعات درمانگر با شناسه")
    @GetMapping("/{id}")
    public PsychologistDto getPsychologist(@PathVariable Long id) {
        return psychologistService.getPsychologist(id);
    }

    @Operation(summary = "بروز رسانی اطلاعات درمانگر")
    @PutMapping("/{id}")
    public PsychologistDto update(@PathVariable Long id, @RequestBody @Valid PsychologistRequest request) {
        return psychologistService.update(id, request);
    }

    @Operation(summary = "حذف اطلاعات درمانگر با شناسه")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        psychologistService.delete(id);
    }
}
