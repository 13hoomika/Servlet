package com.xworkz.jobhuntapp.repo;

import com.xworkz.jobhuntapp.entity.ApplicationEntity;

public interface ApplicationRepo {
    Boolean store(ApplicationEntity entity);
}
