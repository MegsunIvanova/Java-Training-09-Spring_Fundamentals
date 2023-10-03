package org.softuni.supermarket.util;

import jakarta.validation.ConstraintViolation;

import java.util.Set;

public interface ValidationUtil {
    <E> boolean isValid (E object);

    <E> Set<ConstraintViolation<E>> violations(E object);

    <E> String getViolationsMessages(E object);
}
