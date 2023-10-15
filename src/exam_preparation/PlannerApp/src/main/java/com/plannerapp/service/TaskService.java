package com.plannerapp.service;

import com.plannerapp.model.dto.AddTaskDTO;
import com.plannerapp.model.dto.TaskDTO;

import java.util.List;

public interface TaskService {
    void addTask(AddTaskDTO addTaskDTO);

    List<TaskDTO> getAvailableTasks();

    void assign(Long id);

    void remove(Long id);

    void returnTask(Long id);
}
