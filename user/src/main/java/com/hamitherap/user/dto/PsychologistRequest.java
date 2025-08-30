package com.hamitherap.user.dto;

import com.hamitherap.user.validation.NationalId;
import lombok.Data;

import java.util.List;

@Data
public class PsychologistRequest {
    private String firstName;
    private String lastName;
    @NationalId
    private String nationalId;
    private String licenseNumber;
    private String phoneNumber;
    private String email;
    private List<Long> specializationIds;
}
