package com.xworkz.survey.service;

import com.xworkz.survey.dto.SurveyDto;
import com.xworkz.survey.entity.SurveyEntity;
import com.xworkz.survey.repository.SurveyRepository;
import com.xworkz.survey.repository.SurveyRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class SurveyServiceImpl implements SurveyService{
    SurveyRepository repository = new SurveyRepositoryImpl();
    @Override
    public void validateAnsSave(SurveyDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<SurveyDto>> validate = validator.validate(dto);
        if (validate.isEmpty()){
            SurveyEntity entity = new SurveyEntity();
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
