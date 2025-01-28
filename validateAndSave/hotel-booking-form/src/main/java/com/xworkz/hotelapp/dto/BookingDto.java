package com.xworkz.hotelapp.dto;

import lombok.Data;

@Data
public class BookingDto {
    private int roomId;
    private String name;
    private String email;
    private String checkInDate;
    private String checkOutDate;
    private int roomCount;
}
