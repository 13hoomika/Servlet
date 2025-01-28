package com.xworkz.thonosevents.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "event_reg")
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "full_name")
    private String fullName;
    private String email;
    @Column(name = "event_name")
    private String eventName;
    @Column(name = "ticket_type")
    private String ticketType;
    private int attendees;
}
