package com.example.spotifyplaylistapp.service.impl;

import com.example.spotifyplaylistapp.model.dto.UserLoginDTO;
import com.example.spotifyplaylistapp.model.dto.UserRegisterDTO;
import com.example.spotifyplaylistapp.model.entity.UserEntity;
import com.example.spotifyplaylistapp.repository.UserRepository;
import com.example.spotifyplaylistapp.service.AuthService;
import com.example.spotifyplaylistapp.service.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final LoggedUser loggedUser;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository, LoggedUser loggedUser,
                           ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(UserRegisterDTO registerDTO) {
        UserEntity user = modelMapper.map(registerDTO, UserEntity.class);
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));

        userRepository.save(user);

    }

    @Override
    public boolean login(UserLoginDTO loginDTO) {

        Optional<UserEntity> userOpt = userRepository.findByUsername(loginDTO.getUsername());
        if (userOpt.isEmpty()) {
            return false;
        }

        UserEntity user = userOpt.get();

        boolean success = passwordEncoder.matches(loginDTO.getPassword(), user.getPassword());
        if (success) {
            loggedUser.login(user);
        }

        return success;
    }

    @Override
    public void logout() {
        loggedUser.logout();
    }
}
