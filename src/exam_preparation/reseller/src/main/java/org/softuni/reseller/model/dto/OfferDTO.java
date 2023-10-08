package org.softuni.reseller.model.dto;

import org.softuni.reseller.model.entity.Condition;
import org.softuni.reseller.model.entity.User;

import java.math.BigDecimal;

public class OfferDTO {
    private Long id;
    private String description;
    private BigDecimal price;
    private String sellerUsername;
    private String buyerUsername;
    private String conditionName;

    public OfferDTO() {
    }

    public Long getId() {
        return id;
    }

    public OfferDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getSellerUsername() {
        return sellerUsername;
    }

    public OfferDTO setSellerUsername(String sellerUsername) {
        this.sellerUsername = sellerUsername;
        return this;
    }

    public String getBuyerUsername() {
        return buyerUsername;
    }

    public OfferDTO setBuyerUsername(String buyerUsername) {
        this.buyerUsername = buyerUsername;
        return this;
    }

    public String getConditionName() {
        return conditionName;
    }

    public OfferDTO setConditionName(String conditionName) {
        this.conditionName = conditionName;
        return this;
    }
}
