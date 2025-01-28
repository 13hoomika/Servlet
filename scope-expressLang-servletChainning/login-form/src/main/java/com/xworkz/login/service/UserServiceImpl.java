package com.xworkz.login.service;

import com.xworkz.login.dto.UserDto;
import com.xworkz.login.entity.UserEntity;
import com.xworkz.login.repository.UserRepository;
import com.xworkz.login.repository.UserRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class UserServiceImpl implements UserService{
    UserRepository repository = new UserRepositoryImpl();
    @Override
    public void validateAndSave(UserDto userDto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<UserDto>> validate = validator.validate(userDto);
        if (validate.isEmpty()){
            UserEntity userEntity = new UserEntity();
            try {
                BeanUtils.copyProperties(userEntity,userDto);
                repository.save(userEntity);
                System.out.println(userEntity);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }else validate.stream().forEach(err -> System.out.println(err.getMessage()));

    }
}
