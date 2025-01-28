package com.xworkz.paymentapp.dto;

import lombok.Data;

import java.util.SortedSet;

@Data
public class PaymentDto {
    private Integer paymentId;
    private String name;
    private String cardNumber;
    private String expiryDate;
    private String cvv;
    private Double amount;
}
