package com.xworkz.sdit.service;

import com.xworkz.sdit.dto.RegisterDto;

public interface RegisterService {
    Boolean validateAndSave(RegisterDto dto);
}
