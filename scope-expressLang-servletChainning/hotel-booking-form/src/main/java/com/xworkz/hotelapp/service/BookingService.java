package com.xworkz.hotelapp.service;

import com.xworkz.hotelapp.dto.BookingDto;

public interface BookingService {
    void ValidateAndSave(BookingDto dto);
}
