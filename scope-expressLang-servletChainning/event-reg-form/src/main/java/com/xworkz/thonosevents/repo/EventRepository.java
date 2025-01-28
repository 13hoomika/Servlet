package com.xworkz.thonosevents.repo;

import com.xworkz.thonosevents.entity.EventEntity;

public interface EventRepository {
    Boolean save(EventEntity entity);
}
