package com.hamitherap.user.domain;

import com.hamitherap.core.domain.RealPerson;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "patients")
public class Patient extends RealPerson {
    private String medicalRecordNumber;
    private String medicalRecordDate;
    private String medicalRecordType;
}
