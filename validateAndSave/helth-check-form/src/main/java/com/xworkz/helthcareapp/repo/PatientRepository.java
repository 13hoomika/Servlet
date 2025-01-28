package com.xworkz.helthcareapp.repo;

import com.xworkz.helthcareapp.entity.PatientEntity;

public interface PatientRepository {
    Boolean save(PatientEntity patientEntity);
}
