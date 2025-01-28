package com.xworkz.form.service;

import com.xworkz.form.dto.OrderDto;

public interface OrderService {
    void validateAndSave(OrderDto dto);
}
