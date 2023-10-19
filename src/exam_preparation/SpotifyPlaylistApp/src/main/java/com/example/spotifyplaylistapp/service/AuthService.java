package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.dto.UserLoginDTO;
import com.example.spotifyplaylistapp.model.dto.UserRegisterDTO;
import org.springframework.stereotype.Service;

public interface AuthService {

    void register(UserRegisterDTO registerDTO);

    boolean login(UserLoginDTO loginDTO);

    void logout();
}
