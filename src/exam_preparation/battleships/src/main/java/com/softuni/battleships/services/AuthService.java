package com.softuni.battleships.services;

import com.softuni.battleships.models.User;
import com.softuni.battleships.models.dtos.UserLoginDTO;
import com.softuni.battleships.models.dtos.UserRegistrationDTO;
import com.softuni.battleships.repositories.UserRepository;
import com.softuni.battleships.session.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final UserSession userSession;

    @Autowired
    public AuthService(UserRepository userRepository, UserSession userSession) {
        this.userRepository = userRepository;
        this.userSession = userSession;
    }

    public boolean register(UserRegistrationDTO registrationDTO) {
        if (!registrationDTO.getPassword().equals(registrationDTO.getConfirmPassword())) {
            return false;
        }

        Optional<User> byEmail = this.userRepository.findByEmail(registrationDTO.getEmail());
        if (byEmail.isPresent()) {
            return false;
        }

        Optional<User> byUsername = this.userRepository.findByUsername(registrationDTO.getUsername());
        if (byUsername.isPresent()) {
            return false;
        }

        User user = new User();

        user.setUsername(registrationDTO.getUsername())
                .setEmail(registrationDTO.getEmail())
                .setFullName(registrationDTO.getFullName())
                .setPassword(registrationDTO.getPassword());

        this.userRepository.save(user);

        return true;
    }

    public boolean login(UserLoginDTO loginDTO) {
        Optional<User> user = this.userRepository
                .findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());

        if (user.isEmpty()) {
            return false;
        }

        this.userSession.login(user.get());

        return true;

    }

    public void logout() {
        this.userSession.logout();
    }

    public boolean isLoggedIn() {
        return this.userSession.getId() != null;
    }

    public Long getLoggedUserId() {
        return this.userSession.getId();
    }

}
