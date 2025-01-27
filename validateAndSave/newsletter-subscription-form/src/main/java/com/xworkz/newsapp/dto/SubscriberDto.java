package com.xworkz.newsapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
public class SubscriberDto {
    private int subscriberId;
    private String fullName;
    private String emailId;
    private String interests;
    private String country;
    private String frequency;
}
