package com.xworkz.thonosevents.service;

import com.xworkz.thonosevents.dto.EventDto;

public interface EventService {
    void validateAndSave(EventDto eventDto);
}
