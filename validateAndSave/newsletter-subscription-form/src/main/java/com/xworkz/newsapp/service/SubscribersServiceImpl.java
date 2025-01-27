package com.xworkz.newsapp.service;

import com.xworkz.newsapp.dto.SubscriberDto;
import com.xworkz.newsapp.entity.SubscriberEntity;
import com.xworkz.newsapp.repositoty.SubscriberRepo;
import com.xworkz.newsapp.repositoty.SubscriberRepoImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class SubscribersServiceImpl implements SubscribersService{
    SubscriberRepo subscriberRepo = new SubscriberRepoImpl();
    @Override
    public void ValidateAndSave(SubscriberDto subscriberDto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<SubscriberDto>> validate = validator.validate(subscriberDto);
        if (validate.isEmpty()){
            SubscriberEntity subscriberEntity = new SubscriberEntity();
            try {
                BeanUtils.copyProperties(subscriberEntity,subscriberDto);
                subscriberRepo.save(subscriberEntity);
                System.out.println(subscriberEntity);
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
