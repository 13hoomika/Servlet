package com.xworkz.donation.service;

import com.xworkz.donation.dto.DonationDto;
import com.xworkz.donation.entity.DonationEntity;
import com.xworkz.donation.repository.DonationRepository;
import com.xworkz.donation.repository.DonationRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class DonationServiceImpl implements DonationService{
    DonationRepository repository = new DonationRepositoryImpl();

    @Override
    public void validateAndSave(DonationDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<DonationDto>> validate = validator.validate(dto);
        if (validate.isEmpty()){
            DonationEntity entity = new DonationEntity();
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
