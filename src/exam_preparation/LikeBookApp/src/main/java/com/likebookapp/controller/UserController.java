package com.likebookapp.controller;

import com.likebookapp.model.dto.UserLoginDTO;
import com.likebookapp.model.dto.UserRegisterDTO;
import com.likebookapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("registerDTO")
    public UserRegisterDTO initRegisterDTO() {
        return new UserRegisterDTO();
    }

    @ModelAttribute("loginDTO")
    public UserLoginDTO initLoginDTO() {
        return new UserLoginDTO();
    }

    @GetMapping("/register")
    public String register() {
        if (userService.hasLoggedUser()) {
            return "redirect:/";
        }

        return "register";
    }

    @GetMapping("/login")
    public String login() {
        if (userService.hasLoggedUser()) {
            return "redirect:/";
        }

        return "login";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterDTO registerDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (userService.hasLoggedUser()) {
            return "redirect:/";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("registerDTO", registerDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.registerDTO",
                    bindingResult);

            return "redirect:/register";
        }

        userService.register(registerDTO);


        return "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@Valid UserLoginDTO loginDTO,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {
        if (userService.hasLoggedUser()) {
            return "redirect:/";
        }

        if (bindingResult.hasErrors() || !userService.login(loginDTO, bindingResult)) {
            redirectAttributes.addFlashAttribute("loginDTO", loginDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.loginDTO",
                    bindingResult);

            return "redirect:/login";
        }

        return "redirect:/";

    }

    @PostMapping("/logout")
    public String logout () {
        if (!userService.hasLoggedUser()) {
            return "redirect:/";
        }

        userService.logout();

        return "redirect:/";
    }

}
