package org.softuni.supermarket.util;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.softuni.supermarket.repository.CategoryRepository;
import org.softuni.supermarket.repository.ShopRepository;

public class UniqueShopAddressValidator implements ConstraintValidator<UniqueShopAddress, String> {
    private final ShopRepository shopRepository;

    public UniqueShopAddressValidator(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return this.shopRepository
                .findByAddress(value)
                .isEmpty();
    }
}
