package com.plannerapp.vallidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = ExistingUserValidator.class)
public @interface ExistingUser {
    String first();

    String second();

    String message() default "Incorrect username or password!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
