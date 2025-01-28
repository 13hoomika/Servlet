package com.xworkz.helthcareapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "health_check")
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private int patientId;
    @Column(name = "full_name")
    private String fullName;
    private String age;
    private String gender;
    private String symptoms;
    @Column(name = "existing_conditions")
    private String existingConditions;
    private String travel;
}
