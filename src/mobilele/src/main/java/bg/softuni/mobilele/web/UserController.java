package bg.softuni.mobilele.web;

import bg.softuni.mobilele.model.dto.UserLoginDTO;
import bg.softuni.mobilele.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("userModel")
    public UserLoginDTO initUserModel() {
        //TODO: how to return UserLoginDTO with empty fields
        return new UserLoginDTO("", "");
    }

    @GetMapping("/login")
    public String login() {
        return "auth-login";
    }

    @GetMapping("/logout")
    public String logout() {
        userService.logout();
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(@Valid UserLoginDTO userLoginDTO,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors() || this.userService.login(userLoginDTO)) {
            redirectAttributes.addFlashAttribute("userModel", userLoginDTO);
            redirectAttributes.addAttribute("org.springframework.validation.BindingResult.userModel",
                    bindingResult);
            bindingResult.rejectValue("password", "InvalidPasswordError", "Invalid password");

            return "redirect:/users/login";
        }

        return "redirect:/";
    }


}
