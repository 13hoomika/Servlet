package com.xworkz.flipkart.dto;

import lombok.Data;

@Data
public class SupportDto {
    private int customerId;
    private String name;
    private String email;
    private int orderId;
    private String issueType;
    private String description;
}
