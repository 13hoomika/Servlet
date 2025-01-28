package com.xworkz.contactus.service;

import com.xworkz.contactus.dto.ContactDto;

public interface ContactService {
    void processAndSave(ContactDto dto);
}
