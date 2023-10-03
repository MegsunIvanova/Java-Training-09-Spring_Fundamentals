package org.softuni.supermarket.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.softuni.supermarket.util.UniqueCategoryName;

public class AddCategoryDTO {

    @NotEmpty(message = "Name must be minimum two characters!")
    @Size(min = 2, message = "Name must be minimum two characters!")
    @UniqueCategoryName(message = "Category name should be unique!")
    private String name;

    public AddCategoryDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
