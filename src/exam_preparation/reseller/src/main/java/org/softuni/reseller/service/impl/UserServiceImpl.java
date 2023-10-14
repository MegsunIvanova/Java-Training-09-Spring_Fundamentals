package org.softuni.reseller.service.impl;

import org.softuni.reseller.model.dto.UserLoginDTO;
import org.softuni.reseller.model.dto.UserRegisterDTO;
import org.softuni.reseller.model.entity.User;
import org.softuni.reseller.repository.UserRepository;
import org.softuni.reseller.service.LoggedUser;
import org.softuni.reseller.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final LoggedUser loggedUser;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, LoggedUser loggedUser,PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(UserRegisterDTO registerDTO) {
        User user = new User()
                .setUsername(registerDTO.getUsername())
                .setEmail(registerDTO.getEmail())
                .setPassword(passwordEncoder.encode(registerDTO.getPassword()));

        userRepository.save(user);
    }

    @Override
    public boolean isUserLoggedIn() {
        return this.loggedUser.isLogged();
    }


    @Override
    public boolean login(UserLoginDTO loginDTO) {
        Optional<User> optionalUser = userRepository.findByUsername(loginDTO.getUsername());

        if (optionalUser.isEmpty()) {
            return false;
        }

        User user = optionalUser.get();

        String encodedPassword = user.getPassword();
        String rawPassword = loginDTO.getPassword();

        boolean success = passwordEncoder.matches(rawPassword, encodedPassword);

        if (success) {
            loggedUser.login(user.getUsername());
        }

        return success;
    }

    @Override
    public void logout() {
        this.loggedUser.logout();
    }

}
