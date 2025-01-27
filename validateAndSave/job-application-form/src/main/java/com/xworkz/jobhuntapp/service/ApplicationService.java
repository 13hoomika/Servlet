package com.xworkz.jobhuntapp.service;

import com.xworkz.jobhuntapp.dto.ApplicationDto;

public interface ApplicationService {
    void ValidateAndStore(ApplicationDto dto);
}
