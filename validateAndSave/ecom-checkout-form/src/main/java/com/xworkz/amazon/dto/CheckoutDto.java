package com.xworkz.amazon.dto;

import lombok.Data;

@Data
public class CheckoutDto {
    private int customerId;
    private String fullName;
    private String email;
    private String address;
    private String paymentMethod;
    private String orderNotes;

}
