package com.hamitherap.user.repository;

import com.hamitherap.user.domain.Psychologist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PsychologistRepository extends JpaRepository<Psychologist, Long> {
    boolean existsBySpecializations_Id(Long specializationId);
}
