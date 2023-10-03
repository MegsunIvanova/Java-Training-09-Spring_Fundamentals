package org.softuni.supermarket.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "towns")
public class Town extends BaseEntity {

    private String name;

    public Town() {
   }

    public String getName() {
        return name;
    }

    public Town setName(String name) {
        this.name = name;
        return this;
    }
}
