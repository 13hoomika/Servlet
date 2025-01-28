package com.xworkz.flipkart.service;

import com.xworkz.flipkart.dto.SupportDto;
import com.xworkz.flipkart.entity.SupportEntity;
import com.xworkz.flipkart.repository.SupportRepo;
import com.xworkz.flipkart.repository.SupportRepoImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.imageio.spi.ServiceRegistry;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class SupportServiceImpl implements SupportService{
    SupportRepo repo = new SupportRepoImpl();
    @Override
    public void validateAndSave(SupportDto dto) {
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();
        Set<ConstraintViolation<SupportDto>> validate = validator.validate(dto);
        if (validate.isEmpty()){
            SupportEntity entity = new SupportEntity();
            try {
                BeanUtils.copyProperties(entity, dto);
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
