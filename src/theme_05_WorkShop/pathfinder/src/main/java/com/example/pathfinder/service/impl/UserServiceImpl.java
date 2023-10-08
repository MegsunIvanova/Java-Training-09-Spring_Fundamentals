package com.example.pathfinder.service.impl;

import com.example.pathfinder.model.User;
import com.example.pathfinder.repository.UserRepository;
import com.example.pathfinder.service.UserService;
import com.example.pathfinder.service.session.LoggedUser;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final LoggedUser loggedUser;
    private final UserRepository userRepository;

    public UserServiceImpl(LoggedUser loggedUser, UserRepository userRepository) {
        this.loggedUser = loggedUser;
        this.userRepository = userRepository;
    }

    @Override
    public User getLoggedUser() {
        return this.userRepository.findByUsername(loggedUser.getUsername()).get();
    }
}
