package com.hamitherap.user.repository;

import com.hamitherap.user.domain.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecializationRepository extends JpaRepository<Specialization, Long> {
    boolean existsBySpecializationNameIgnoreCase(String name);
}
