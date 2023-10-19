package com.example.spotifyplaylistapp.controller;

import com.example.spotifyplaylistapp.model.dto.HomePageDTO;
import com.example.spotifyplaylistapp.service.LoggedUser;
import com.example.spotifyplaylistapp.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final LoggedUser loggedUser;
    private final SongService songService;


    public HomeController(LoggedUser loggedUser, SongService songService) {
        this.loggedUser = loggedUser;
        this.songService = songService;
    }

    @GetMapping("/")
    public String home(Model model) {
        if (loggedUser.isLogged()) {
            HomePageDTO homePageDTO = songService.getHomePageDTO();
            model.addAttribute("homePageDTO", homePageDTO);

            return "home";
        } else {
            return "index";
        }
    }
}
