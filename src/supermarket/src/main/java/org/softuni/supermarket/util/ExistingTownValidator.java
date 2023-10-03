package org.softuni.supermarket.util;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.softuni.supermarket.repository.TownRepository;

public class ExistingTownValidator implements ConstraintValidator<ExistingTown, String> {

    private final TownRepository townRepository;

    public ExistingTownValidator(TownRepository townRepository) {
        this.townRepository = townRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return this.townRepository.findByName(value).isPresent();
    }
}
