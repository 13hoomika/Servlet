package com.xworkz.form.service;

import com.xworkz.form.dto.ReservationDto;
import com.xworkz.form.entity.ReservationEntity;
import com.xworkz.form.repository.ReservationRepoImpl;
import com.xworkz.form.repository.ReservationRepository;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class ReservationServiceImpl implements ReservationService{
    ReservationRepository repository = new ReservationRepoImpl();
    @Override
    public void validateAndSave(ReservationDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<ReservationDto>> validate = validator.validate(dto);
        if (validate.isEmpty()){
            ReservationEntity entity = new ReservationEntity();
            try {
                BeanUtils.copyProperties(entity,dto);
                repository.save(entity);
                System.out.println(entity);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }else validate.stream().forEach(err-> System.out.println(err.getMessage()));
    }
}
