package com.xworkz.amazon.service;

import com.xworkz.amazon.dto.CheckoutDto;
import com.xworkz.amazon.entity.CheckoutEntity;
import com.xworkz.amazon.repo.CheckoutRepo;
import com.xworkz.amazon.repo.CheckoutRepoImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class CheckoutServiceImpl implements CheckoutService{
    CheckoutRepo checkoutRepo = new CheckoutRepoImpl();
    @Override
    public void validateAndStore(CheckoutDto checkoutDto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<CheckoutDto>> validate = validator.validate(checkoutDto);
        if (validate.isEmpty()){
            CheckoutEntity entity = new CheckoutEntity();
            try {
                BeanUtils.copyProperties(entity,checkoutDto);
                checkoutRepo.persistData(entity);
                System.out.println(entity);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }else
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
    }
}
