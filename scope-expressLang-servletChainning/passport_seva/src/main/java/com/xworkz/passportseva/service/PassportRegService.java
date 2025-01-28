package com.xworkz.passportseva.service;

import com.xworkz.passportseva.dto.PassportRegDto;

public interface PassportRegService {
    Boolean validateAndSave(PassportRegDto dto);
}
