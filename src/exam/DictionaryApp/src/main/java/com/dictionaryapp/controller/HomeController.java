package com.dictionaryapp.controller;

import com.dictionaryapp.model.dto.HomeViewDTO;
import com.dictionaryapp.service.LoggedUser;
import com.dictionaryapp.service.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final LoggedUser loggedUser;
    private final WordService wordService;

    public HomeController(LoggedUser loggedUser, WordService wordService) {
        this.loggedUser = loggedUser;
        this.wordService = wordService;
    }

    @GetMapping("/")
    public String home(Model model) {
        if (loggedUser.isLogged()) {
            HomeViewDTO homeViewDTO = wordService.generateHomeView();
            model.addAttribute("homeViewDTO", homeViewDTO);

            return "home";
        }

        return "index";
    }

}
