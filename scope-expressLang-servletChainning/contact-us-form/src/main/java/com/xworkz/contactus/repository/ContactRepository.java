package com.xworkz.contactus.repository;

import com.xworkz.contactus.entity.ContactEntity;

public interface ContactRepository {
    Boolean save(ContactEntity entity);
}
