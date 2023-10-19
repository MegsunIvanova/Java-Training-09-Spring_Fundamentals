package com.example.spotifyplaylistapp.controller;

import com.example.spotifyplaylistapp.model.dto.SongAddDTO;
import com.example.spotifyplaylistapp.service.LoggedUser;
import com.example.spotifyplaylistapp.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class SongController {
    private final LoggedUser loggedUser;
    private final SongService songService;

    public SongController(LoggedUser loggedUser, SongService songService) {
        this.loggedUser = loggedUser;
        this.songService = songService;
    }

    @ModelAttribute("songAddDTO")
    public SongAddDTO songAddDTO() {
        return new SongAddDTO();
    }

    @GetMapping("/song/add")
    private String add() {
        if (!loggedUser.isLogged()) {
            return "redirect:/login";
        }

        return "song-add";
    }

    @PostMapping("song/add")
    private String add(@Valid SongAddDTO songAddDTO,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {
        if (!loggedUser.isLogged()) {
            return "redirect:/login";
        }

        if (bindingResult.hasErrors() || !songService.add(songAddDTO)) {
            redirectAttributes.addFlashAttribute("songAddDTO", songAddDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.songAddDTO",
                    bindingResult);

            return "redirect:/song/add";
        }

        return "redirect:/";
    }

    @PostMapping("song/addToPlaylist/{id}")
    public String addToPlaylist(@PathVariable("id") Long id) {
        if (!loggedUser.isLogged()) {
            return "redirect:/login";
        }

        songService.addToPlaylist(id);

        return "redirect:/";
    }

    @PostMapping("song/removeAll")
    public String removeAllFromPlaylist() {
        if (!loggedUser.isLogged()) {
            return "redirect:/login";
        }

        songService.clearUserPlaylist();

        return "redirect:/";
    }
}
