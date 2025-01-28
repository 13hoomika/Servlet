package com.xworkz.login.service;

import com.xworkz.login.dto.UserDto;

public interface UserService {
    void validateAndSave(UserDto userDto);
}
