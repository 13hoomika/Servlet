package com.xworkz.sdit.service;

import com.xworkz.sdit.dto.RegisterDto;
import com.xworkz.sdit.entity.RegisterEntity;
import com.xworkz.sdit.repository.RegisterRepo;
import com.xworkz.sdit.repository.RegisterRepoImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class RegisterServiceImpl implements RegisterService {
    RegisterRepo registerRepo =new RegisterRepoImpl();
    @Override
    public Boolean validateAndSave(RegisterDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<RegisterDto>> validate = validator.validate(dto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            RegisterEntity registerEntity = new RegisterEntity();
            try {
                BeanUtils.copyProperties(registerEntity, dto);
                System.out.println(registerEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            registerRepo.save(registerEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }
}

