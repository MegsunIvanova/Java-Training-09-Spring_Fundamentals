package com.example.pathfinder.controller;

import com.example.pathfinder.model.dto.UserLoginDTO;
import com.example.pathfinder.model.dto.UserRegistrationDTO;
import com.example.pathfinder.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @ModelAttribute("userRegistrationDTO")
    public UserRegistrationDTO initForm() {
        return new UserRegistrationDTO();
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView login(UserLoginDTO loginDTO) {

        boolean isLogged = authService.login(loginDTO);

        if(isLogged) {
            return new ModelAndView("redirect:/");
        }

        return new ModelAndView("login");
    }

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView doRegister(@Valid UserRegistrationDTO userRegistrationDTO,
                                   BindingResult bindingResult,
                                   RedirectAttributes redirectAttributes) {
    //TODO: validate DTO
//        if (bindingResult.hasErrors()) {
//            redirectAttributes.addFlashAttribute("userRegistrationDTO", userRegistrationDTO);
//
//            redirectAttributes.addFlashAttribute(
//                    "org.springframework.validation.BindingResult.userRegistrationDTO",
//                    bindingResult);
//
//
//            return new ModelAndView("redirect:register");
//        }

        this.authService.register(userRegistrationDTO);


        return new ModelAndView("redirect:login");
    }

    //TODO: PostMapping for logout()
    @GetMapping("/logout")
    public ModelAndView logout () {
        this.authService.logout();

        return new ModelAndView("redirect:/");
    }

}
