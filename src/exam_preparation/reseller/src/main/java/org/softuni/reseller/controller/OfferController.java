package org.softuni.reseller.controller;

import jakarta.validation.Valid;
import org.softuni.reseller.model.dto.AddOfferDTO;
import org.softuni.reseller.service.OfferService;
import org.softuni.reseller.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/offer/add")
    public String addOffer() {
        if (!this.userService.isUserLoggedIn()) {
            return "redirect:/";
        }

        return "/offer-add";
    }

    @PostMapping("/offer/add")
    public String addOffer(@Valid AddOfferDTO addOfferDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (!this.userService.isUserLoggedIn()) {
            return "redirect:/";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addOfferDTO", addOfferDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.addOfferDTO", bindingResult);

            return "redirect:/offer/add";
        }

        this.offerService.createOffer(addOfferDTO);

        return "redirect:/";
    }

    @GetMapping("/offer/{id}/buy")
    public String buyOffer(@PathVariable("id") Long id) {
        if (!this.userService.isUserLoggedIn()) {
            return "redirect:/";
        }

        this.offerService.buyOffer(id);

        return "redirect:/";
    }


    @GetMapping("/offer/{id}/remove")
    public String removeOffer(@PathVariable("id") Long id) {
        if (!this.userService.isUserLoggedIn()) {
            return "redirect:/";
        }

        this.offerService.removeOffer(id);

        return "redirect:/";
    }
}
