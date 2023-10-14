package org.softuni.reseller.controller;

import org.softuni.reseller.model.dto.HomeModelDTO;
import org.softuni.reseller.service.OfferService;
import org.softuni.reseller.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private final UserService userService;
    private final OfferService offerService;

    public HomeController(UserService userService, OfferService offerService) {
        this.userService = userService;
        this.offerService = offerService;
    }


    @GetMapping("/")
    public ModelAndView home() {
        if (this.userService.isUserLoggedIn()) {
            ModelAndView modelAndView = new ModelAndView("home");
            HomeModelDTO homeModelDTO = offerService.getHomeModelDTO();
            modelAndView.addObject("homeModel", homeModelDTO);

            return modelAndView;

        } else {
            return new ModelAndView("index");
        }
    }
}
