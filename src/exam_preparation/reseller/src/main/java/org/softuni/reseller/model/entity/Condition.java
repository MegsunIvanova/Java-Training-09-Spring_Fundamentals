package org.softuni.reseller.model.entity;

import jakarta.persistence.*;
import org.softuni.reseller.model.enums.ConditionNameEnum;

@Entity
@Table(name = "conditions")
public class Condition extends BaseEntity {

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private ConditionNameEnum name;

    @Column(nullable = false)
    private String description;

    public Condition() {
    }

    public Condition(ConditionNameEnum name) {
        this.name = name;
        this.description = name.getDescription();
    }

    public ConditionNameEnum getName() {
        return name;
    }

    public Condition setName(ConditionNameEnum name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Condition setDescription(String description) {
        this.description = description;
        return this;
    }
}
