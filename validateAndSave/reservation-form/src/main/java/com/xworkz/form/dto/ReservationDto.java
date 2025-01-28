package com.xworkz.form.dto;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.Data;

@Data
public class ReservationDto {
    private int reservationId;
    private String name;
    private String email;
    private long phone;
    private String reservationDate;
    private int guestCount;
}
