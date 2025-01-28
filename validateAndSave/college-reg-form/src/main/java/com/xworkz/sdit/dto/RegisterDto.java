package com.xworkz.sdit.dto;

import lombok.Data;

@Data
public class RegisterDto {
    private Integer id;
    private String fullName;
    private Long contactNumber;
    private String qualification;
    private String emailId;
    private String usn;
    private int yearOfpass;
}
