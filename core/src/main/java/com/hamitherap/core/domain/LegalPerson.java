package com.hamitherap.core.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "legal_persons")
public class LegalPerson extends Person{
    @Column(nullable = false)
    private String companyName;

    @Column(unique = true)
    private String registrationNumber;
}
