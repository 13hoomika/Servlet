package com.xworkz.form.service;

import com.xworkz.form.dto.VolunteerDto;
import com.xworkz.form.entity.VolunteerEntity;
import com.xworkz.form.repo.VolunteerRepository;
import com.xworkz.form.repo.VolunteerRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class VolunteerServiceImpl implements VolunteerService {
    VolunteerRepository repository = new VolunteerRepositoryImpl();
    @Override
    public void validateAndSave(VolunteerDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<VolunteerDto>> validate = validator.validate(dto);
        if (validate.isEmpty()){
            VolunteerEntity entity = new VolunteerEntity();
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
