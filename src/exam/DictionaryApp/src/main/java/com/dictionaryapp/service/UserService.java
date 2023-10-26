package com.dictionaryapp.service;

import com.dictionaryapp.model.dto.LoginDTO;
import com.dictionaryapp.model.dto.RegisterDTO;

public interface UserService {
    void register(RegisterDTO registerDTO);

    boolean login(LoginDTO loginDTO);

    void logout();
}
