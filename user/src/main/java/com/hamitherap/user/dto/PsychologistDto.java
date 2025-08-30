package com.hamitherap.user.dto;

import lombok.Data;

import java.util.List;

@Data
public class PsychologistDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String licenceNumber;
    private List<SpecializationDto> specializations;
}
