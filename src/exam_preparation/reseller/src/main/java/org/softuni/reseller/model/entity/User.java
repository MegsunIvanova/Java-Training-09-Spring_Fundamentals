package org.softuni.reseller.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(targetEntity = Offer.class, mappedBy = "seller", fetch = FetchType.EAGER)
    private List<Offer> offers;


    @OneToMany(targetEntity = Offer.class, mappedBy = "buyer", fetch = FetchType.EAGER)
    private List<Offer> boughtOffers;

    public User() {
        this.offers = new ArrayList<>();
        this.boughtOffers = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public User setOffers(List<Offer> offers) {
        this.offers = offers;
        return this;
    }

    public List<Offer> getBoughtOffers() {
        return boughtOffers;
    }

    public User setBoughtOffers(List<Offer> boughtOffers) {
        this.boughtOffers = boughtOffers;
        return this;
    }
}
