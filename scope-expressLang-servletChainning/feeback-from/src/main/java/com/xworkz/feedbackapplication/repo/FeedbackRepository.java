package com.xworkz.feedbackapplication.repo;

import com.xworkz.feedbackapplication.entity.FeedbackEntity;

public interface FeedbackRepository {
    Boolean save(FeedbackEntity entity);
}
