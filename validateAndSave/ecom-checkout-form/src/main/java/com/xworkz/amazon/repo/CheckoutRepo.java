package com.xworkz.amazon.repo;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.xworkz.amazon.entity.CheckoutEntity;

public interface CheckoutRepo {
    Boolean persistData(CheckoutEntity entity);
}
