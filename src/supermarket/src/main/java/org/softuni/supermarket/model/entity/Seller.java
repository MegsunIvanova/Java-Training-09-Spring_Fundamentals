package org.softuni.supermarket.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "sellers")
public class Seller extends BaseEntity {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private BigDecimal salary;

    @ManyToOne
    private Shop shop;

    @ManyToOne
    private Seller manager;

    public Seller() {
    }

    public String getFirstName() {
        return firstName;
    }

    public Seller setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Seller setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Seller setAge(Integer age) {
        this.age = age;
        return this;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public Seller setSalary(BigDecimal salary) {
        this.salary = salary;
        return this;
    }

    public Shop getShop() {
        return shop;
    }

    public Seller setShop(Shop shop) {
        this.shop = shop;
        return this;
    }

    public Seller getManager() {
        return manager;
    }

    public Seller setManager(Seller manager) {
        this.manager = manager;
        return this;
    }
}
