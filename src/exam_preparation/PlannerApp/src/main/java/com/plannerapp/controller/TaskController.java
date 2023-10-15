package com.plannerapp.controller;

import com.plannerapp.model.dto.AddTaskDTO;
import com.plannerapp.model.enums.PriorityName;
import com.plannerapp.service.TaskService;
import com.plannerapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;
    private final UserService userService;

    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @ModelAttribute("priorityNames")
    public PriorityName[] priorityNames() {
        return PriorityName.values();
    }

    @ModelAttribute("addTaskDTO")
    public AddTaskDTO initTaskDTO() {
        return new AddTaskDTO();
    }

    @GetMapping("/add")
    public String addTask() {
        if (!userService.hasLoggedUser()) {
            return "redirect:/";
        }

        return "task-add";
    }

    @PostMapping("/add")
    public String addTask(@Valid AddTaskDTO addTaskDTO,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {
        if (!userService.hasLoggedUser()) {
            return "redirect:/";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addTaskDTO", addTaskDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.addTaskDTO", bindingResult);

            return "redirect:/task/add";
        }

        this.taskService.addTask(addTaskDTO);

        return "redirect:/";
    }

    @PostMapping("/assign/{id}")
    public String assignTask(@PathVariable("id") Long id) {
        if (!userService.hasLoggedUser()) {
            return "redirect:/";
        }

        taskService.assign(id);

        return "redirect:/";
    }

    @PostMapping("/return/{id}")
    public String returnTask(@PathVariable("id") Long id) {
        if (!userService.hasLoggedUser()) {
            return "redirect:/";
        }

        taskService.returnTask(id);

        return "redirect:/";
    }

    @PostMapping("/remove/{id}") //TODO: DELETE REQUEST
    public String removeTask(@PathVariable("id") Long id) {
        if (!userService.hasLoggedUser()) {
            return "redirect:/";
        }

        taskService.remove(id);

        return "redirect:/";
    }
}
