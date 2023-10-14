package org.softuni.reseller.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.softuni.reseller.model.enums.ConditionNameEnum;

@Entity
@Table(name = "conditions")
public class Condition extends BaseEntity {

    @NotNull
    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private ConditionNameEnum name;

    @NotEmpty
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
        this.setDescription(name.getDescription());
        return this;
    }

    public String getDescription() {
        return description;
    }

    private Condition setDescription(String description) {
        this.description = description;
        return this;
    }
}
