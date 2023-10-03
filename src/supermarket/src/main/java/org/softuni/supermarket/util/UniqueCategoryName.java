package org.softuni.supermarket.util;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UniqueCategoryNameValidator.class)
public @interface UniqueCategoryName {
    String message() default "Invalid Name";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
