package com.xworkz.form.repository;

import com.xworkz.form.dto.ReservationDto;
import com.xworkz.form.entity.ReservationEntity;

public interface ReservationRepository {
    Boolean save(ReservationEntity entity);
}

