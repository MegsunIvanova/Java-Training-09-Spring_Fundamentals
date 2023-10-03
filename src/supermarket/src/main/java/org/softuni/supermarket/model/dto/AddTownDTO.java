package org.softuni.supermarket.model.dto;

import jakarta.validation.constraints.NotEmpty;

public class AddTownDTO {

    @NotEmpty(message = "The name shouldn't be empty!")
    private String name;

    public AddTownDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
