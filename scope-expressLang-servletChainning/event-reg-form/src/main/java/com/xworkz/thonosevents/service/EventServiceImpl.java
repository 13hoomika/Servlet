package com.xworkz.thonosevents.service;

import com.xworkz.thonosevents.dto.EventDto;
import com.xworkz.thonosevents.entity.EventEntity;
import com.xworkz.thonosevents.repo.EventRepository;
import com.xworkz.thonosevents.repo.EventRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class EventServiceImpl implements EventService{
    EventRepository repository = new EventRepositoryImpl();
    @Override
    public void validateAndSave(EventDto eventDto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<EventDto>> validate = validator.validate(eventDto);
        if (validate.isEmpty()){
            EventEntity entity = new EventEntity();
            try {
                BeanUtils.copyProperties(entity,eventDto);
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
