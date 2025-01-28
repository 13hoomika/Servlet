package com.xworkz.contactus.dto;

import lombok.Data;

@Data
public class ContactDto {
    private int requesterId;
    private String name;
    private String email;
    private String category;
    private String message;
    private long phone;
}
