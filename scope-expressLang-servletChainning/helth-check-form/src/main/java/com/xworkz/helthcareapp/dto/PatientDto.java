package com.xworkz.helthcareapp.dto;

import lombok.Data;

@Data
public class PatientDto {
    private int patientId;
    private String fullName;
    private String age;
    private String gender;
    private String symptoms;
    private String existingConditions;
    private String travel;
}
