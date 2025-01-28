package com.xworkz.donation.dto;

import lombok.Data;

@Data
public class DonationDto {
    private int donationId;
    private String name;
    private String email;
    private String donationType;
    private Double amount;
    private String message;
}
