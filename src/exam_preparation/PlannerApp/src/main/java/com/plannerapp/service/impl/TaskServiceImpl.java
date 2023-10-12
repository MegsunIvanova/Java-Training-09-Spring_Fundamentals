package com.plannerapp.service.impl;

import com.plannerapp.model.dto.AddTaskDTO;
import com.plannerapp.model.dto.TaskDTO;
import com.plannerapp.model.entity.Priority;
import com.plannerapp.model.entity.Task;
import com.plannerapp.repo.PriorityRepository;
import com.plannerapp.repo.TaskRepository;
import com.plannerapp.service.TaskService;
import com.plannerapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    private final ModelMapper mapper;
    private final TaskRepository taskRepository;
    private final PriorityRepository priorityRepository;

    public TaskServiceImpl(ModelMapper mapper, TaskRepository taskRepository, PriorityRepository priorityRepository) {
        this.mapper = mapper;
        this.taskRepository = taskRepository;
        this.priorityRepository = priorityRepository;
    }

    @Override
    @Transactional
    public void addTask(AddTaskDTO addTaskDTO) {
        Task task = mapper.map(addTaskDTO, Task.class);

        Priority priority = priorityRepository.findByName(addTaskDTO.getPriority());
        task.setPriority(priority);
        priority.addTask(task);

        taskRepository.save(task);
        priorityRepository.save(priority);
    }

    @Override
    public List<TaskDTO> getAvailableTasks() {
        return  this.taskRepository.findAllByUserIsNull()
                .stream()
                .map(task -> mapper.map(task, TaskDTO.class))
                .collect(Collectors.toList());
    }
}
