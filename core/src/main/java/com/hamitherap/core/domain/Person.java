package com.hamitherap.core.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "persons")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Long id;

    @NotBlank(message = "ایمیل الزامی است")
    @Column(nullable = false)
    private String email;

    @NotBlank(message = "شماره تلفن الزامی است")
    @Column(nullable = false)
    private String phoneNumber;
}
