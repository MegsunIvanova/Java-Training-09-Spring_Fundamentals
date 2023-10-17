package com.likebookapp.controller;

import com.likebookapp.model.dto.HomePageDTO;
import com.likebookapp.service.PostService;
import com.likebookapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final UserService userService;
    private final PostService postService;

    public HomeController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @GetMapping("/")
    public String home(Model model) {
        if (userService.hasLoggedUser()) {
            HomePageDTO homePageDTO = postService.getHomePageDTO();
            model.addAttribute("homePageDTO", homePageDTO);

            return "home";
        } else {
            return "index";
        }
    }
}
