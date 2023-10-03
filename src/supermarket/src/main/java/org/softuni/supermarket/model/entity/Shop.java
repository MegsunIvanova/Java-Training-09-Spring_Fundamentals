package org.softuni.supermarket.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shops")
public class Shop extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String address;

    private String name;

    @ManyToOne
    private Town town;

    @ManyToMany
    private List<Product> products;

    public Shop() {
        this.products = new ArrayList<>();
    }

    public String getAddress() {
        return address;
    }

    public Shop setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getName() {
        return name;
    }

    public Shop setName(String name) {
        this.name = name;
        return this;
    }

    public Town getTown() {
        return town;
    }

    public Shop setTown(Town town) {
        this.town = town;
        return this;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Shop setProducts(List<Product> products) {
        this.products = products;
        return this;
    }
}
