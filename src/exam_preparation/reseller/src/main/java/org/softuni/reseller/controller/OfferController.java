package org.softuni.reseller.controller;

import jakarta.validation.Valid;
import org.softuni.reseller.model.dto.AddOfferDTO;
import org.softuni.reseller.service.OfferService;
import org.softuni.reseller.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@Controller
public class OfferController {

    private final OfferService offerService;
    private final UserService userService;

    public OfferController(OfferService offerService, UserService userService) {
        this.offerService = offerService;
        this.userService = userService;
    }

    @ModelAttribute("addOfferDTO")
    public AddOfferDTO initAddOfferDTO() {
        return new AddOfferDTO();
    }

    @GetMapping("/offers/add")
    public ModelAndView addOffer() {
        if (!this.userService.isUserLoggedIn()) {
            return new ModelAndView("redirect:/");
        }

        return new ModelAndView("/offer-add");
    }

    @PostMapping("/offers/add")
    public ModelAndView addOffer(@Valid AddOfferDTO addOfferDTO,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {

        if (!this.userService.isUserLoggedIn()) {
            return new ModelAndView("redirect:/");
        }

        if (bindingResult.hasErrors() || !offerService.createOffer(addOfferDTO)) {
            redirectAttributes.addFlashAttribute("addOfferDTO", addOfferDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.addOfferDTO", bindingResult);

            return new ModelAndView("redirect:/offers/add");
        }

        return new ModelAndView("redirect:/");
    }

    @PostMapping("/offers/buy/{id}")
    public ModelAndView buyOffer(@PathVariable("id") UUID id) {
        if (!userService.isUserLoggedIn()) {
            return new ModelAndView("redirect:/");
        }

        offerService.buyOffer(id);

        return new ModelAndView("redirect:/");
    }

    @PostMapping("/offers/remove/{id}")
    public ModelAndView removeOffer(@PathVariable("id") UUID id) {
        if (!this.userService.isUserLoggedIn()) {
            return new ModelAndView("redirect:/");
        }

        this.offerService.removeOffer(id);

        return new ModelAndView("redirect:/");
    }
}
