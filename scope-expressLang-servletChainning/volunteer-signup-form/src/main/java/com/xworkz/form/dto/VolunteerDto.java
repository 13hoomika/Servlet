package com.xworkz.form.dto;

import lombok.Data;

@Data
public class VolunteerDto {
    private int volunteerId;
    private String volunteerName;
    private String email;
    private String skills;
    private String availability;
    private String location;
}
