package com.plannerapp.service.impl;

import com.plannerapp.model.dto.AddTaskDTO;
import com.plannerapp.model.dto.TaskDTO;
import com.plannerapp.model.entity.Priority;
import com.plannerapp.model.entity.Task;
import com.plannerapp.model.entity.User;
import com.plannerapp.repo.PriorityRepository;
import com.plannerapp.repo.TaskRepository;
import com.plannerapp.repo.UserRepository;
import com.plannerapp.service.LoggedUser;
import com.plannerapp.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    private final ModelMapper mapper;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final PriorityRepository priorityRepository;
    private final LoggedUser loggedUser;

    public TaskServiceImpl(ModelMapper mapper, TaskRepository taskRepository, UserRepository userRepository,
                           PriorityRepository priorityRepository, LoggedUser loggedUser) {
        this.mapper = mapper;
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.priorityRepository = priorityRepository;
        this.loggedUser = loggedUser;
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
        return taskRepository
                .findAllByUserIsNull()
                .stream()
                .map(task -> mapper.map(task, TaskDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void assign(Long id) {
        Optional<Task> taskOpt = taskRepository.findTaskByIdAndUserIsNull(id);

        String username = loggedUser.getUsername();

        Optional<User> userOpt = userRepository.findUserByUsernameWithTasks(username);

        if (taskOpt.isEmpty() || userOpt.isEmpty()) {
            return;
        }

        Task task = taskOpt.get().setUser(userOpt.get());

        User user = userOpt.get().assignTask(task);

        taskRepository.save(task);
        userRepository.save(user);

    }

    @Override
    public void returnTask(Long id) {
        String username = loggedUser.getUsername();
        Optional<User> userOpt = userRepository.findUserByUsernameWithTasks(username);

        if (userOpt.isEmpty()) {
            return;
        }

        Optional<Task> taskOpt = taskRepository.findTaskByIdAndUser(id, userOpt.get());

        if (taskOpt.isEmpty()) {
            return;
        }

        Task task = taskOpt.get().setUser(null);
        User user = userOpt.get().removeTask(task);

        taskRepository.save(task);
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void remove(Long id) {
        taskRepository.deleteById(id);
    }
}
