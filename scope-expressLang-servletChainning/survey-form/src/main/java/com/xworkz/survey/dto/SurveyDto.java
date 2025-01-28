package com.xworkz.survey.dto;

import lombok.Data;

@Data
public class SurveyDto {
    private int surveyId;
    private String name;
    private String email;
    private int age;
    private String gender;
    private String feedback;
}
