package org.softuni.reseller.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.softuni.reseller.model.enums.ConditionNameEnum;

import java.math.BigDecimal;

public class AddOfferDTO {

    @NotEmpty
    @Size(min=2, max = 50)
    private String description;


    @NotNull
    @Positive
    private BigDecimal price;

    @NotNull
    private ConditionNameEnum condition;

    public AddOfferDTO() {
    }

    public String getDescription() {
        return description;
    }

    public AddOfferDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AddOfferDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public ConditionNameEnum getCondition() {
        return condition;
    }

    public AddOfferDTO setCondition(ConditionNameEnum condition) {
        this.condition = condition;
        return this;
    }
}
