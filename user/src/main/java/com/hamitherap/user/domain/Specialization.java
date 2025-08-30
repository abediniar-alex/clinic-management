package com.hamitherap.user.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "specializations",
uniqueConstraints = {@UniqueConstraint(columnNames = "specializationName")})
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @Size(min = 3, max = 100, message = "عنوان تخخص باید بین 3 تا 100 حرف باشد")
    private String specializationName;
}
