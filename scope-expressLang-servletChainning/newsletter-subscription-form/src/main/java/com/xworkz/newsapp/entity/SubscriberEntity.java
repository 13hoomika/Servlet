package com.xworkz.newsapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "newsletter_subscribers")
@ToString
public class SubscriberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscriber_id")
    private int subscriberId;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "email_id")
    private String emailId;
    private String interests;
    private String country;
    private String frequency;
}
