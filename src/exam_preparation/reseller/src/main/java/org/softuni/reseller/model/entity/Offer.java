package org.softuni.reseller.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Entity
@Table(name = "offers")
@NamedEntityGraph(
        name = "offersWithUsers",
        attributeNodes = {@NamedAttributeNode("seller"), @NamedAttributeNode("buyer")}
)
public class Offer extends BaseEntity {

    @NotEmpty
    @Size(min = 2, max = 50)
    @Column(nullable = false)
    private String description;

    @NotNull
    @Positive
    @Column(nullable = false)
    private BigDecimal price;

    @ManyToOne
    private User seller;

    @ManyToOne
    private User buyer;

    @NotNull
    @ManyToOne
    private Condition condition;

    public Offer() {
    }

    public String getDescription() {
        return description;
    }

    public Offer setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Offer setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public User getSeller() {
        return seller;
    }

    public Offer setSeller(User seller) {
        this.seller = seller;
        return this;
    }

    public User getBuyer() {
        return buyer;
    }

    public Offer setBuyer(User buyer) {
        this.buyer = buyer;
        return this;
    }

    public Condition getCondition() {
        return condition;
    }

    public Offer setCondition(Condition condition) {
        this.condition = condition;
        return this;
    }
}
