package com.xworkz.passportseva.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "passport_seva")
public class PassportRegEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "applicant_name")
    private String applicantName;
    private String dob;
    @Column(name = "email_id")
    private String emailId;
    @Column(name = "mobile_number")
    private Long mobileNumber;
    private String address;
    private Integer pinCode;
}
