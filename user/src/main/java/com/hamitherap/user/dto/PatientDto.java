package com.hamitherap.user.dto;

import lombok.Data;

@Data
public class PatientDto {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String medicalRecordNumber;
}
