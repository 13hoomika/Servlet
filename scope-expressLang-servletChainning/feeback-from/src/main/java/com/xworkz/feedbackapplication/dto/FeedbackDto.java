package com.xworkz.feedbackapplication.dto;

import lombok.Data;

@Data
public class FeedbackDto {
    private int id;
    private String name;
    private String email;
    private String feedback;
}
