package com.plannerapp.vallidation;

import com.plannerapp.service.UserService;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistingUserValidator implements ConstraintValidator<ExistingUser, Object> {
    private final UserService userService;
    String first;
    String second;
    String message;

    public ExistingUserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(ExistingUser constraintAnnotation) {
        this.first = constraintAnnotation.first();
        this.second = constraintAnnotation.second();
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(value);
        String firstValue = (String) beanWrapper.getPropertyValue(this.first);
        String secondValue = (String) beanWrapper.getPropertyValue(this.second);

        boolean valid = userService.isExistingUser(firstValue, secondValue);

        if(!valid) {
            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(second)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }

        return valid;
    }
}
