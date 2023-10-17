package com.likebookapp.model.entity;

import com.likebookapp.model.enums.MoodName;

import javax.persistence.*;

@Entity
@Table(name = "moods")
public class MoodEntity extends BaseEntity{

    //name: unique, not null
    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private MoodName name;

    private String description;

    public MoodEntity() {
    }

    public MoodEntity(MoodName name) {
        this.name = name;
    }

    public MoodName getName() {
        return name;
    }

    public MoodEntity setName(MoodName name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public MoodEntity setDescription(String description) {
        this.description = description;
        return this;
    }
}
