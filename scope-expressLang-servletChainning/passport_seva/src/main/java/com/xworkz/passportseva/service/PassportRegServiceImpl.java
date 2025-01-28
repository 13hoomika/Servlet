package com.xworkz.passportseva.service;

import com.xworkz.passportseva.dto.PassportRegDto;
import com.xworkz.passportseva.entity.PassportRegEntity;
import com.xworkz.passportseva.repository.PassportRegRepository;
import com.xworkz.passportseva.repository.PassportRegRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class PassportRegServiceImpl implements PassportRegService {
    PassportRegRepository passportRegRepository = new PassportRegRepositoryImpl();

    @Override
    public Boolean validateAndSave(PassportRegDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<PassportRegDto>> validate = validator.validate(dto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            PassportRegEntity passportRegEntity = new PassportRegEntity();
            try {
                BeanUtils.copyProperties(passportRegEntity, dto);
                System.out.println(passportRegEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            passportRegRepository.save(passportRegEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }
}