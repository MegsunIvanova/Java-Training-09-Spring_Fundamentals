package org.softuni.reseller.model.enums;

public enum ConditionNameEnum {
    EXCELLENT ("In perfect condition"),
    GOOD ("Some signs of wear and tear or minor defects"),
    ACCEPTABLE ("The item is fairly worn but continues to function properly");

    public final String description;

    ConditionNameEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
