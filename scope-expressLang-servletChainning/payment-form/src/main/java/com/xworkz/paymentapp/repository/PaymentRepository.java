package com.xworkz.paymentapp.repository;

import com.xworkz.paymentapp.entity.PaymentEntity;

public interface PaymentRepository {
    Boolean save(PaymentEntity entity);
}
