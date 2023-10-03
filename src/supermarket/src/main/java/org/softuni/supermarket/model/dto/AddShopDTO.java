package org.softuni.supermarket.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.softuni.supermarket.util.ExistingTown;
import org.softuni.supermarket.util.UniqueShopAddress;

public class AddShopDTO {

    @NotEmpty(message = "The address must be at least 2 characters!")
    @UniqueShopAddress(message = "The address should be unique!")
    @Size(min = 2, message = "The address must be at least 2 characters!")
    private String address;

    @Size(min = 2, message = "The name must be at least 2 characters!")
    private String name;


    @ExistingTown
    private String townName;


    private String[] details;

    public AddShopDTO() {
    }

    public AddShopDTO(String... args) {
        this.name = args[0];
        this.address = args[1];
        this.townName = args[2];
    }


}
