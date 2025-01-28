package com.xworkz.feedbackapplication.service;

import com.xworkz.feedbackapplication.dto.FeedbackDto;
import com.xworkz.feedbackapplication.entity.FeedbackEntity;
import com.xworkz.feedbackapplication.repo.FeedbackRepoImpl;
import com.xworkz.feedbackapplication.repo.FeedbackRepository;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class FeedbackServiceImpl implements FeedbackService{
    FeedbackRepository feedbackRepository = new FeedbackRepoImpl();
    @Override
    public void validateAndSave(FeedbackDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<FeedbackDto>> validate = validator.validate(dto);
        if (validate.isEmpty()){
            FeedbackEntity feedbackEntity = new FeedbackEntity();
            try {
                BeanUtils.copyProperties(feedbackEntity,dto);
                feedbackRepository.save(feedbackEntity);
                System.out.println(feedbackEntity);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }else validate.stream().forEach(err-> System.out.println(err.getMessage()));

    }
}
