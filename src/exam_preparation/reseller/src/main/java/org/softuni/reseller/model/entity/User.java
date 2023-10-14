package org.softuni.reseller.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @NotEmpty
    @Size(min=3, max = 20)
    @Column(nullable = false, unique = true)
    private String username;

    @NotEmpty
    @Column(nullable = false)
    private String password;

    @NotEmpty
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(targetEntity = Offer.class, mappedBy = "seller", fetch = FetchType.EAGER)
    private Set<Offer> offers;


    @OneToMany(targetEntity = Offer.class, mappedBy = "buyer", fetch = FetchType.EAGER)
    private Set<Offer> boughtOffers;

    public User() {
        this.offers = new HashSet<>();
        this.boughtOffers = new HashSet<>();
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

    public Set<Offer> getOffers() {
        return offers;
    }

    public User setOffers(Set<Offer> offers) {
        this.offers = offers;
        return this;
    }

    public Set<Offer> getBoughtOffers() {
        return boughtOffers;
    }

    public User setBoughtOffers(Set<Offer> boughtOffers) {
        this.boughtOffers = boughtOffers;
        return this;
    }
}
