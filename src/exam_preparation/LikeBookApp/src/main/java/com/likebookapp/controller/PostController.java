package com.likebookapp.controller;

import com.likebookapp.model.dto.CreatePostDTO;
import com.likebookapp.service.PostService;
import com.likebookapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/post")
public class PostController {
    private final UserService userService;
    private final PostService postService;

    public PostController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @ModelAttribute("createPostDTO")
    public CreatePostDTO initCreatePostDTO() {
        return new CreatePostDTO();
    }

    @GetMapping("/add")
    public String create() {
        if (!userService.hasLoggedUser()) {
            return "redirect:/";
        }

        return "post-add";
    }

    @PostMapping("/add")
    public String create(@Valid CreatePostDTO createPostDTO,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if (!userService.hasLoggedUser()) {
            return "redirect:/";
        }

        if (bindingResult.hasErrors() || !postService.create(createPostDTO)) {
            redirectAttributes.addFlashAttribute("createPostDTO", createPostDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.createPostDTO", bindingResult);

            return "redirect:/post/add";
        }

        return "redirect:/";
    }

    @PostMapping("/remove/{id}")
    public String remove(@PathVariable("id") Long id) {
        if (!userService.hasLoggedUser()) {
            return "redirect:/";
        }

        postService.remove(id);

        return "redirect:/";
    }

    @PostMapping("/like/{id}")
    public String like(@PathVariable("id") Long id) {
        if (!userService.hasLoggedUser()) {
            return "redirect:/";
        }

        postService.like(id);

        return "redirect:/";
    }
}
