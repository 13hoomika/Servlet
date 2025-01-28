package com.xworkz.form.service;

import com.xworkz.form.dto.OrderDto;
import com.xworkz.form.entity.OrderEntity;
import com.xworkz.form.repository.OrderRepoImpl;
import com.xworkz.form.repository.OrderRepository;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class OrderServiceImpl implements OrderService{
    OrderRepository repository = new OrderRepoImpl();
    @Override
    public void validateAndSave(OrderDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<OrderDto>> validate = validator.validate(dto);
        if (validate.isEmpty()){
            OrderEntity entity = new OrderEntity();
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
