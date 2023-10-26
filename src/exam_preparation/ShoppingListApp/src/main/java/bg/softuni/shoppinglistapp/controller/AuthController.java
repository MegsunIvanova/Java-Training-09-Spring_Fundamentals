package bg.softuni.shoppinglistapp.controller;

import bg.softuni.shoppinglistapp.model.dto.LoginDTO;
import bg.softuni.shoppinglistapp.model.dto.RegisterDTO;
import bg.softuni.shoppinglistapp.service.AuthService;
import bg.softuni.shoppinglistapp.service.LoggedUser;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {
    private final LoggedUser loggedUser;
    private final AuthService authService;

    public AuthController(LoggedUser loggedUser, AuthService authService) {
        this.loggedUser = loggedUser;
        this.authService = authService;
    }

    @ModelAttribute("registerDTO")
    public RegisterDTO registerDTO() {
        return new RegisterDTO();
    }

    @ModelAttribute("loginDTO")
    public LoginDTO loginDTO() {
        return new LoginDTO();
    }

    @GetMapping("/login")
    public String login() {
        if (loggedUser.isLogged()) {
            return "redirect:/";
        }

        return "login";
    }

    @GetMapping("/register")
    public String register() {
        if (loggedUser.isLogged()) {
            return "redirect:/";
        }

        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid RegisterDTO registerDTO,
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

    @PostMapping("/login")
    public String login(@Valid LoginDTO loginDTO,
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

    @PostMapping("/logout")
    public String logout() {
        if (!loggedUser.isLogged()) {
            return "redirect:/";
        }

        authService.logout();

        return "redirect:/";
    }

}
