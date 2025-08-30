package com.hamitherap.user.domain;

import com.hamitherap.core.domain.RealPerson;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "psychologists")
public class Psychologist extends RealPerson {

    @Column(nullable = false, unique = true)
    private String licenseNumber;

    @ManyToMany
    @JoinTable(
            name = "psychologist_specializations",
            joinColumns = @JoinColumn(name = "psychologist_id"),
            inverseJoinColumns = @JoinColumn(name = "specialization_id")
    )
    private List<Specialization> specializations;
}
