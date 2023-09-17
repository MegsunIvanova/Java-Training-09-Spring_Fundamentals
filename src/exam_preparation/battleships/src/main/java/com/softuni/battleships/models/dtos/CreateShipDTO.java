package com.softuni.battleships.models.dtos;

import com.softuni.battleships.models.enums.ShipType;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class CreateShipDTO {

    @NotEmpty
    @Size(min = 2, max = 10)
    private String name;

    @Positive
    private long power;

    @Positive
    private long health;

    @PastOrPresent
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate created;

    @NotNull
    private ShipType category;

    public CreateShipDTO() {
    }

    public String getName() {
        return name;
    }

    public CreateShipDTO setName(String name) {
        this.name = name;
        return this;
    }

    public long getPower() {
        return power;
    }

    public CreateShipDTO setPower(long power) {
        this.power = power;
        return this;
    }

    public long getHealth() {
        return health;
    }

    public CreateShipDTO setHealth(long health) {
        this.health = health;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public CreateShipDTO setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public ShipType getCategory() {
        return category;
    }

    public CreateShipDTO setCategory(ShipType category) {
        this.category = category;
        return this;
    }
}
