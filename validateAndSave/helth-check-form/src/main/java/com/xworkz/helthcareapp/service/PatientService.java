package com.xworkz.helthcareapp.service;

import com.xworkz.helthcareapp.dto.PatientDto;

public interface PatientService {
    void validateAndSave(PatientDto dto);
}
