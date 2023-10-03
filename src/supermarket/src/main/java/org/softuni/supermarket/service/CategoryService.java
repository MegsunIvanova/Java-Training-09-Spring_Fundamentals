package org.softuni.supermarket.service;

import jakarta.validation.Valid;
import org.softuni.supermarket.model.dto.AddCategoryDTO;
import org.springframework.validation.BindingResult;

public interface CategoryService {

    String addCategory(AddCategoryDTO categoryName);

}
