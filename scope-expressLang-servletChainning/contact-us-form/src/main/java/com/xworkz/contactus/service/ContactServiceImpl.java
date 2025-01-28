package com.xworkz.contactus.service;

import com.xworkz.contactus.dto.ContactDto;
import com.xworkz.contactus.entity.ContactEntity;
import com.xworkz.contactus.repository.ContactRepository;
import com.xworkz.contactus.repository.ContactRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class ContactServiceImpl implements ContactService {
ContactRepository repository = new ContactRepositoryImpl();
    @Override
    public void processAndSave(ContactDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<ContactDto>> validate = validator.validate(dto);
        if (validate.isEmpty()){
            ContactEntity entity = new ContactEntity();
            try {
                BeanUtils.copyProperties(entity,dto);
                repository.save(entity);
                System.out.println(entity);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }else validate.stream().forEach(err -> System.out.println(err.getMessage()));

    }
}
