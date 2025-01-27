package com.xworkz.xworkzapp.service;

import com.xworkz.xworkzapp.dto.EnrollmentDto;
import com.xworkz.xworkzapp.entity.EnrollmentEntity;
import com.xworkz.xworkzapp.repo.EnrollmentRepo;
import com.xworkz.xworkzapp.repo.EnrollmentRepoImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class EnrollmentServiceImpl implements EnrollmentService{
    EnrollmentRepo repo = new EnrollmentRepoImpl();
    @Override
    public void validateAndPersist(EnrollmentDto dto){
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<EnrollmentDto>> validate = validator.validate(dto);
        if (validate.isEmpty()){
            EnrollmentEntity entity = new EnrollmentEntity();
            try {
                BeanUtils.copyProperties(entity,dto);
                repo.save(entity);
                System.out.println(entity);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }else {
            validate.stream().forEach(err -> System.out.println(err.getMessage()));

        }
    }
}
