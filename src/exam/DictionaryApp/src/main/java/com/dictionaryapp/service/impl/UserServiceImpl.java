package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.dto.LoginDTO;
import com.dictionaryapp.model.dto.RegisterDTO;
import com.dictionaryapp.model.entity.UserEntity;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.service.LoggedUser;
import com.dictionaryapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final LoggedUser loggedUser;

    public UserServiceImpl(ModelMapper modelMapper, PasswordEncoder passwordEncoder, UserRepository userRepository, LoggedUser loggedUser) {
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
    }

    @Override
    public void register(RegisterDTO registerDTO) {
        UserEntity user = modelMapper.map(registerDTO, UserEntity.class);
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));

        userRepository.save(user);
    }

    @Override
    public boolean login(LoginDTO loginDTO) {
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
