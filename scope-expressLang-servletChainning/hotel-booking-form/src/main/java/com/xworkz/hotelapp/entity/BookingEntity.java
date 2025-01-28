package com.xworkz.hotelapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hotel_booking")
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private int roomId;
    private String name;
    private String email;
    @Column(name = "checkin_date")
    private String checkInDate;
    @Column(name = "checkout_date")
    private String checkOutDate;
    @Column(name = "room_count")
    private int roomCount;
}
