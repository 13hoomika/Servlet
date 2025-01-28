package com.xworkz.passportseva.dto;

import lombok.Data;

@Data
public class PassportRegDto {
    private Integer id;
    private String applicantName;
    private String dob;
    private String emailId;
    private Long mobileNumber;
    private String address;
    private Integer pinCode;
}
