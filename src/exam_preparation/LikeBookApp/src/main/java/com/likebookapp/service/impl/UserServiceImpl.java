package com.likebookapp.service.impl;

import com.likebookapp.model.dto.UserLoginDTO;
import com.likebookapp.model.dto.UserRegisterDTO;
import com.likebookapp.model.entity.UserEntity;
import com.likebookapp.repository.UserRepository;
import com.likebookapp.service.LoggedUser;
import com.likebookapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final LoggedUser loggedUser;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, LoggedUser loggedUser, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean hasLoggedUser() {
        return loggedUser.isLogged();
    }

    @Override
    public void register(UserRegisterDTO registerDTO) {

        UserEntity user = modelMapper.map(registerDTO, UserEntity.class);
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));

        userRepository.save(user);
    }

    @Override
    public String getLoggedUsername() {
        return loggedUser.getUsername();
    }

    @Override
    public void logout() {
        loggedUser.logout();
    }


    @Override
    public boolean login(UserLoginDTO loginDTO, BindingResult bindingResult) {
        Optional<UserEntity> userOpt = userRepository.findByUsername(loginDTO.getUsername());

        if (userOpt.isEmpty()) {
            bindingResult.addError(new ObjectError("loginDTO", "Username not found!"));
            return false;
        }

        UserEntity user = userOpt.get();

        if (!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            bindingResult.addError(new ObjectError("loginDTO", "Incorrect password!"));
            return false;
        }

        loggedUser.login(user);

        return true;
    }

}
