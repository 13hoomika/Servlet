package com.xworkz.app.service;

import com.xworkz.app.dto.MembersDto;
import com.xworkz.app.entity.MembersEntity;
import com.xworkz.app.repository.MembersRepository;
import com.xworkz.app.repository.MembersRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class MembersServiceImpl implements MembersService{
    MembersRepository repository = new MembersRepositoryImpl();
    @Override
    public void ValidateAndSave(MembersDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<MembersDto>> validate = validator.validate(dto);
        if (validate.isEmpty()){
            MembersEntity entity = new MembersEntity();
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
