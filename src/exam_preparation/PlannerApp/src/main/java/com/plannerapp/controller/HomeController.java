package com.plannerapp.controller;

import com.plannerapp.model.dto.TaskDTO;
import com.plannerapp.service.UserService;
import com.plannerapp.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final UserService userService;
    private final TaskService taskService;

    public HomeController(UserService userService, TaskService taskService) {
        this.userService = userService;
        this.taskService = taskService;
    }

//    @ModelAttribute("homeDto")
//    public HomePageDTO initHomeDto() {
//        return new HomePageDTO();
//    }

    @GetMapping("/")
    public String home(Model model) {
        if (userService.hasLoggedUser()) {

            String loggedUsername = this.userService.getLoggedUser();
            model.addAttribute("username", loggedUsername);

            List<TaskDTO> assignedTasks = this.userService.getAssignedTasks();
            model.addAttribute("assignedTasks", assignedTasks);

            List<TaskDTO> availableTasks = this.taskService.getAvailableTasks();
            model.addAttribute("availableTasks", availableTasks);

            return "home";

        } else {
            return "index";
        }
    }
}
