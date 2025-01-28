package com.xworkz.donation.service;

import com.xworkz.donation.dto.DonationDto;

public interface DonationService {
    void validateAndSave(DonationDto dto);
}
