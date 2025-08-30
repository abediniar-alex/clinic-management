package com.hamitherap.user.service.impl;

import com.hamitherap.user.domain.Psychologist;
import com.hamitherap.user.domain.Specialization;
import com.hamitherap.user.dto.PsychologistDto;
import com.hamitherap.user.dto.PsychologistRequest;
import com.hamitherap.user.mapper.impl.PsychologistMapper;
import com.hamitherap.user.repository.PsychologistRepository;
import com.hamitherap.user.repository.SpecializationRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class PsychologistServiceImplTest {
    private AutoCloseable closeable;

    @Mock
    private PsychologistRepository psychologistRepository;

    @Mock
    private SpecializationRepository specializationRepository;

    @Mock
    PsychologistMapper psychologistMapper;

    @InjectMocks
    private PsychologistServiceImpl psychologistService;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
        psychologistService = new PsychologistServiceImpl(
                psychologistRepository, specializationRepository, psychologistMapper
        );
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close(); // ensures mocks are released
    }

    @Test
    void createPsychologist_ShouldReturnDto() {
        PsychologistRequest request = new PsychologistRequest();
        request.setFirstName("اسکندر");
        request.setLastName("عابدینی");
        request.setLicenseNumber("12545487");
        request.setEmail("abedini.ar@gmail.com");
        request.setPhoneNumber("09127513205");
        request.setSpecializationIds(List.of(1L));

        Specialization specialization = new Specialization();
        specialization.setId(1L);
        specialization.setSpecializationName("CBT");

        Psychologist savedEntity = new Psychologist();
        savedEntity.setId(1L);
        savedEntity.setFirstName("اسکندر");
        savedEntity.setLastName("عابدینی");
        savedEntity.setLicenseNumber("12545487");
        savedEntity.setEmail("abedini.ar@gmail.com");
        savedEntity.setPhoneNumber("09127513205");
        savedEntity.setSpecializations(List.of(specialization));

        when(specializationRepository.findAllById(List.of(1L)))
                .thenReturn(List.of(specialization));
        when(psychologistRepository.save(any(Psychologist.class)))
                .thenReturn(savedEntity);

        PsychologistDto result = psychologistService.create(request);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("اسکندر", result.getFirstName());
    }

    @Test
    void create() {
    }

    @Test
    void getPsychologists() {
    }

    @Test
    void getPsychologist_ShouldReturnDto_WhenFound() {
        Psychologist entity = new Psychologist();
        entity.setId(1L);
        entity.setFirstName("اسکندر");

        when(psychologistRepository.findById(1L)).thenReturn(Optional.of(entity));
        when(psychologistMapper.toDto(any(Psychologist.class))).thenAnswer(invocation -> {
            Psychologist p = invocation.getArgument(0);
            PsychologistDto dto = new PsychologistDto();
            dto.setId(p.getId());
            dto.setFirstName(p.getFirstName());
            return dto;
        });

        PsychologistDto result = psychologistService.getPsychologist(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("اسکندر", result.getFirstName());
    }

    @Test
    void getPsychologist() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}