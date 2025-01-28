package com.xworkz.amazon.service;

import com.xworkz.amazon.dto.CheckoutDto;

public interface CheckoutService {
    void validateAndStore(CheckoutDto checkoutDto);
}
