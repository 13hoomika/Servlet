package com.xworkz.thonosevents.dto;

import lombok.Data;

@Data
public class EventDto {
    private int id;
    private String fullName;
    private String email;
    private String eventName;
    private String ticketType;
    private int attendees;
}
