package com.xworkz.form.dto;

import lombok.Data;

@Data
public class OrderDto {
    private int orderId;
    private String productName;
    private int quantity;
    private String customerName;
    private String address;
    private long phone;
}
