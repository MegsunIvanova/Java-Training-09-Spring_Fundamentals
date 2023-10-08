package org.softuni.reseller.controller;

import jakarta.validation.Valid;
import org.softuni.reseller.model.dto.HomeModelDTO;
import org.softuni.reseller.model.dto.UserLoginDTO;
import org.softuni.reseller.model.dto.UserRegisterDTO;
import org.softuni.reseller.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {
    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("registrationDTO")
    public UserRegisterDTO initRegistrationDTO() {
        return new UserRegisterDTO();
    }

    @ModelAttribute("loginDTO")
    public UserLoginDTO initLoginDTO() {
        return new UserLoginDTO();
    }

    @ModelAttribute("homeModel")
    public HomeModelDTO initHomeModel() {
        return new HomeModelDTO();
    }

    @GetMapping("/")
    public String home(Model model) {
        if (this.userService.isUserLoggedIn()) {

            HomeModelDTO homeModelDTO = userService.createHomeModelDTO();

            model.addAttribute("homeModel", homeModelDTO);

            return "home";
        } else {
            return "index";
        }
    }

    @GetMapping("/login")
    public String login() {
        if (!this.userService.isUserLoggedIn()) {
            return "login";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/login")
    public String login(@Valid UserLoginDTO loginDTO,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {

        if (this.userService.isUserLoggedIn()) {
            return "redirect:/";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("loginDTO", loginDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.loginDTO", bindingResult);

            return "redirect:/login";
        }

        boolean loginSuccess = this.userService.login(loginDTO);

        if (!loginSuccess) {
            bindingResult.addError(new ObjectError("loginDTO", "Wrong Credential"));
            redirectAttributes.addFlashAttribute("loginDTO", loginDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.loginDTO", bindingResult);

            return "redirect:/login";
        }

        return "redirect:/";
    }

    @GetMapping("/register")
    public String register() {
        if (this.userService.isUserLoggedIn()) {
            return "redirect:/";
        }

        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterDTO registrationDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (this.userService.isUserLoggedIn()) {
            return "redirect:/";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("registrationDTO", registrationDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.registrationDTO", bindingResult);
            return "redirect:/register";
        }

        this.userService.register(registrationDTO);

        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout() {
        if (!this.userService.isUserLoggedIn()) {
            return "redirect:/";
        }

        this.userService.logout();
        return "redirect:/";
    }
}
