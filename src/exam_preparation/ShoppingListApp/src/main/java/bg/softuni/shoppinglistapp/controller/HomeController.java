package bg.softuni.shoppinglistapp.controller;

import bg.softuni.shoppinglistapp.model.dto.HomeViewDTO;
import bg.softuni.shoppinglistapp.service.CategoryService;
import bg.softuni.shoppinglistapp.service.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final LoggedUser loggedUser;
    private final CategoryService categoryService;

    public HomeController(LoggedUser loggedUser, CategoryService categoryService) {
        this.loggedUser = loggedUser;
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public String home(Model model) {
        if (loggedUser.isLogged()) {
            HomeViewDTO homeViewDTO =categoryService.createHomeViewDTO();
            model.addAttribute("homeViewDTO", homeViewDTO);
            return "home";
        }

        return "index";
    }
}
