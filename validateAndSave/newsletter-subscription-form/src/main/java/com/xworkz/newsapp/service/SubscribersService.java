package com.xworkz.newsapp.service;

import com.xworkz.newsapp.dto.SubscriberDto;

public interface SubscribersService {
    void ValidateAndSave(SubscriberDto subscriberDto);
}
