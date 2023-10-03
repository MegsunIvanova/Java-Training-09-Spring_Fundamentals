package org.softuni.supermarket.util;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = ExistingTownValidator.class)
public @interface ExistingTown {

    String message() default "Invalid Town name";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
