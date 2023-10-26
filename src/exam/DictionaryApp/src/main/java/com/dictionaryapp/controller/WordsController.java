package com.dictionaryapp.controller;

import com.dictionaryapp.model.dto.AddWordDTO;
import com.dictionaryapp.service.LoggedUser;
import com.dictionaryapp.service.WordService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/word")
public class WordsController {
    private final LoggedUser loggedUser;
    private final WordService wordService;

    public WordsController(LoggedUser loggedUser, WordService wordService) {
        this.loggedUser = loggedUser;
        this.wordService = wordService;
    }

    @ModelAttribute("wordDTO")
    public AddWordDTO wordDTO() {
        return new AddWordDTO();
    }

    @GetMapping("/add")
    public String createWord() {
        if (!loggedUser.isLogged()) {
            return "redirect:/login";
        }

        return "word-add";
    }

    @PostMapping("/add")
    public String createWord(@Valid AddWordDTO wordDTO,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        if (!loggedUser.isLogged()) {
            return "redirect:/login";
        }

        if (bindingResult.hasErrors() || !wordService.create(wordDTO)) {
            redirectAttributes.addFlashAttribute("wordDTO", wordDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.wordDTO", bindingResult);

            return "redirect:/word/add";
        }

        return "redirect:/";
    }

    @PostMapping("/remove/{id}")
    public String removeWordByID(@PathVariable("id") Long id) {
        if (!loggedUser.isLogged()) {
            return "redirect:/login";
        }

        wordService.removeWord(id);

        return "redirect:/";
    }

    @PostMapping("/remove-all")
    public String removeAll () {
        if (!loggedUser.isLogged()) {
            return "redirect:/login";
        }

        wordService.removeAll();

        return "redirect:/";
    }

}
