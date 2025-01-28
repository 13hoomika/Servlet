package com.xworkz.xworkzapp.service;

import com.xworkz.xworkzapp.dto.EnrollmentDto;

import java.lang.reflect.InvocationTargetException;

public interface EnrollmentService {
    void validateAndPersist(EnrollmentDto dto);
}
