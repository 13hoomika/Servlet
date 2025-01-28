package com.xworkz.form.service;

import com.xworkz.form.dto.ReservationDto;

public interface ReservationService {
    void validateAndSave(ReservationDto dto);
}
