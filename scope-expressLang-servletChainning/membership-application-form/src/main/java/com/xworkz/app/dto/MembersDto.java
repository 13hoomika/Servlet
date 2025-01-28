package com.xworkz.app.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MembersDto {
    private int memberId;
    private String name;
    private String email;
    private String startDate;
    private String membershipType;
    private String referral;
}

