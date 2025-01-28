package com.xworkz.hotelapp.repository;

import com.xworkz.hotelapp.entity.BookingEntity;

public interface BookingRepository {
    Boolean save(BookingEntity entity);
}
