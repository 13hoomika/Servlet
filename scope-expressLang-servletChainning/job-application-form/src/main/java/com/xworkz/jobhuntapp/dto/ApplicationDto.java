package com.xworkz.jobhuntapp.dto;

import lombok.Data;

@Data
public class ApplicationDto {
    private int applicationId;
    public String fullName;
    public String email;
    public long phone;
    public String position;
    public int experience;

}
