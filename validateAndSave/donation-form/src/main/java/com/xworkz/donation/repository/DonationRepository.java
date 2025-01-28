package com.xworkz.donation.repository;

import com.xworkz.donation.entity.DonationEntity;

public interface DonationRepository {
    Boolean save(DonationEntity entity);
}
