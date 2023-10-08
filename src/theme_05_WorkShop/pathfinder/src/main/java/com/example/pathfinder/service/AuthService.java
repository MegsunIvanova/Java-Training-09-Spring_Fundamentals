package com.example.pathfinder.service;

import com.example.pathfinder.model.dto.UserLoginDTO;
import com.example.pathfinder.model.dto.UserRegistrationDTO;

public interface AuthService {
    void register(UserRegistrationDTO registrationDTO);

    boolean login(UserLoginDTO loginDTO);

    void logout();
}
