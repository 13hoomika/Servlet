package com.xworkz.feedbackapplication.service;

import com.xworkz.feedbackapplication.dto.FeedbackDto;

public interface FeedbackService {
    void validateAndSave(FeedbackDto dto);
}
