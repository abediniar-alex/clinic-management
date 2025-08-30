package com.hamitherap.core.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name = "real_persons")
public class RealPerson extends Person {
    @NotBlank(message = "نام الزامی است")
    @Column(nullable = false)
    private String firstName;

    @NotBlank(message = "نام خانوادگی الزامی است")
    @Column(nullable = false)
    private String lastName;

    @NotBlank(message = "کد ملی الزامی است")
    @Column(unique = true, nullable = false)
    private String nationalId;
}
