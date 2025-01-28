package com.xworkz.paymentapp.service;

import com.xworkz.paymentapp.dto.PaymentDto;
import com.xworkz.paymentapp.entity.PaymentEntity;
import com.xworkz.paymentapp.repository.PaymentRepository;
import com.xworkz.paymentapp.repository.PaymentRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class PaymentServiceImpl implements PaymentService{
    PaymentRepository repository = new PaymentRepositoryImpl();
    @Override
    public void validateAndSave(PaymentDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<PaymentDto>> validate = validator.validate(dto);
        if (validate.isEmpty()){
            PaymentEntity entity = new PaymentEntity();
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
