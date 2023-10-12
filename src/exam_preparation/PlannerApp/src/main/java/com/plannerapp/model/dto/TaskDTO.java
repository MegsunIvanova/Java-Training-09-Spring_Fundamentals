package com.plannerapp.model.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class TaskDTO {

    private Long id;

    private String priorityName;

//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

    private String description;

    public TaskDTO() {
    }

    public Long getId() {
        return id;
    }

    public TaskDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getPriorityName() {
        return priorityName;
    }

    public TaskDTO setPriorityName(String priorityName) {
        this.priorityName = priorityName;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskDTO setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TaskDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
