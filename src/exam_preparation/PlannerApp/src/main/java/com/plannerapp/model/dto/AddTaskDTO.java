package com.plannerapp.model.dto;

import com.plannerapp.model.entity.Priority;
import com.plannerapp.model.enums.PriorityName;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class AddTaskDTO {

    @NotEmpty (message = "Description cannot be empty!")
    @Size(min=2, max = 50, message = "Description length must be between 2 and 50 characters!")
    private String description;

    @Future (message = "Due date must be in future!")
    @NotNull(message = "Due date cannot be null!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

    @NotNull(message = "You must select priority!")
    private PriorityName priority;

    public AddTaskDTO() {
    }

    public String getDescription() {
        return description;
    }

    public AddTaskDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public AddTaskDTO setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public PriorityName getPriority() {
        return priority;
    }

    public AddTaskDTO setPriority(PriorityName priority) {
        this.priority = priority;
        return this;
    }
}
