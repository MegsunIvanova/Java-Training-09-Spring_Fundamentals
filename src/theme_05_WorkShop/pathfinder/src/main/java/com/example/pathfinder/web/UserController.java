package com.example.pathfinder.web;

import com.example.pathfinder.model.User;
import com.example.pathfinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @RequestMapping(path ="/users/all", method = RequestMethod.GET)
//    or:
    @GetMapping("/users/all")
//    @ResponseBody
    public List<User> getALl () {
       return this.userService.getAll();
    }
}
