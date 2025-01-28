package com.xworkz.login.repository;

import com.xworkz.login.entity.UserEntity;

public interface UserRepository {
    Boolean save(UserEntity userEntity);
}
