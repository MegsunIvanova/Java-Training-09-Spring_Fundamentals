package org.softuni.supermarket.service.impl;

import jakarta.validation.ConstraintViolation;
import org.softuni.supermarket.model.dto.AddCategoryDTO;
import org.softuni.supermarket.model.entity.Category;
import org.softuni.supermarket.repository.CategoryRepository;
import org.softuni.supermarket.service.CategoryService;
import org.softuni.supermarket.util.ValidationUtil;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final ValidationUtil validator;
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(ValidationUtil validator, CategoryRepository categoryRepository) {
        this.validator = validator;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public String addCategory(AddCategoryDTO categoryDTO) {
        if (this.validator.isValid(categoryDTO)) {
            Category category = new Category()
                    .setName(categoryDTO.getName());
            this.categoryRepository.save(category);
            return "Successfully adding a new category";

        } else {
            return this.validator.getViolationsMessages(categoryDTO);
        }
    }
}
