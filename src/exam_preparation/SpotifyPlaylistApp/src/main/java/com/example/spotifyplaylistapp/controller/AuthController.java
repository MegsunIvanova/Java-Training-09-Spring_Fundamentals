package com.example.spotifyplaylistapp.controller;

import com.example.spotifyplaylistapp.model.dto.UserLoginDTO;
import com.example.spotifyplaylistapp.model.dto.UserRegisterDTO;
import com.example.spotifyplaylistapp.service.AuthService;
import com.example.spotifyplaylistapp.service.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class AuthController {
    private final LoggedUser loggedUser;
    private final AuthService authService;

    public AuthController(LoggedUser loggedUser, AuthService authService) {
        this.loggedUser = loggedUser;
        this.authService = authService;
    }

    @ModelAttribute("registerDTO")
    public UserRegisterDTO registerDTO() {
        return new UserRegisterDTO();
    }

    @ModelAttribute("loginDTO")
    public UserLoginDTO loginDTO() {
        return new UserLoginDTO();
    }

    @GetMapping("/login")
    public String login() {
        if (loggedUser.isLogged()) {
            return "redirect:/";
        }

        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid UserLoginDTO loginDTO,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {
        if (loggedUser.isLogged()) {
            return "redirect:/";
        }

        boolean loginSuccess = false;

        if (!bindingResult.hasErrors()) {
            loginSuccess = authService.login(loginDTO);
            if (!loginSuccess) {
                bindingResult.addError(
                        new ObjectError("loginDTO", "Incorrect username or password.")
                );
            }
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("loginDTO", loginDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.loginDTO", bindingResult);

            return "redirect:/login";
        }

        return "redirect:/";
    }

    @GetMapping("/register")
    public String register() {
        if (loggedUser.isLogged()) {
            return "redirect:/";
        }

        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterDTO registerDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (loggedUser.isLogged()) {
            return "redirect:/";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("registerDTO", registerDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.registerDTO", bindingResult);

            return "redirect:/register";
        }

        authService.register(registerDTO);
        return "redirect:/login";
    }

    @PostMapping("/logout")
    public String logout() {
        if (!loggedUser.isLogged()) {
            return "redirect:/";
        }

        authService.logout();

        return "redirect:/";
    }

}
