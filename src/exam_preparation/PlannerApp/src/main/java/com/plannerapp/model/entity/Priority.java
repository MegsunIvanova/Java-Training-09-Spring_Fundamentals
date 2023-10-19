package com.plannerapp.model.entity;

import com.plannerapp.model.enums.PriorityName;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "priorities")
public class Priority extends BaseEntity {

    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private PriorityName name;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "priority", targetEntity = Task.class)
    private List<Task> tasks;

    public Priority() {
        this.tasks = new ArrayList<>();
    }

    public Priority(PriorityName name) {
        this();
        this.name = name;
        this.description = name.getDescription();
    }

    public PriorityName getName() {
        return name;
    }

    public Priority setName(PriorityName name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Priority setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public Priority setTasks(List<Task> tasks) {
        this.tasks = tasks;
        return this;
    }

    public Priority addTask(Task task) {
        this.tasks.add(task);
        return this;
    }
}
