package com.xworkz.paymentapp.service;

import com.xworkz.paymentapp.dto.PaymentDto;

public interface PaymentService {
    void validateAndSave(PaymentDto dto);
}
