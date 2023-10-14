package org.softuni.reseller.controller;

import jakarta.validation.Valid;
import org.softuni.reseller.model.dto.UserLoginDTO;
import org.softuni.reseller.model.dto.UserRegisterDTO;
import org.softuni.reseller.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
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

    @GetMapping("/login")
    public ModelAndView login() {
        if (!this.userService.isUserLoggedIn()) {
            return new ModelAndView("login");
        } else {
            return new ModelAndView("redirect:/");
        }
    }

    @PostMapping("/login")
    public ModelAndView login(@Valid UserLoginDTO loginDTO,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {

        if (this.userService.isUserLoggedIn()) {
            return new ModelAndView("redirect:/");
        }

        if (bindingResult.hasErrors() || !userService.login(loginDTO)) {
            redirectAttributes.addFlashAttribute("loginDTO", loginDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.loginDTO", bindingResult);

            return new ModelAndView("redirect:/login");
        }

        return new ModelAndView("redirect:/");
    }

    @GetMapping("/register")
    public ModelAndView register() {
        if (this.userService.isUserLoggedIn()) {
            return new ModelAndView("redirect:/");
        }

        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView register(@Valid UserRegisterDTO registrationDTO,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {

        if (this.userService.isUserLoggedIn()) {
            return new ModelAndView("redirect:/");
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("registrationDTO", registrationDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.registrationDTO", bindingResult);
            return new ModelAndView("redirect:/register");
        }

        this.userService.register(registrationDTO);

        return new ModelAndView("redirect:/login");
    }

    @PostMapping("/logout")
    public ModelAndView logout() {
        if (this.userService.isUserLoggedIn()) {
            this.userService.logout();
        }

        return new ModelAndView("redirect:/");
    }
}
