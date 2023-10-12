package com.plannerapp.controller;

import com.plannerapp.model.dto.AddTaskDTO;
import com.plannerapp.model.enums.PriorityName;
import com.plannerapp.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
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
        return "task-add";
    }

    @PostMapping("/add")
    public String addTask(@Valid AddTaskDTO addTaskDTO,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addTaskDTO", addTaskDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.addTaskDTO", bindingResult);

            return "redirect:/task/add";
        }

       this.taskService.addTask(addTaskDTO);

        return "redirect:/";
    }
}
