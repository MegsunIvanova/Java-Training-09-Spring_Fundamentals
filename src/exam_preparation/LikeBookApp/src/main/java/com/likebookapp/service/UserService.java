package com.likebookapp.service;

import com.likebookapp.model.dto.PostDTO;
import com.likebookapp.model.dto.UserLoginDTO;
import com.likebookapp.model.dto.UserRegisterDTO;
import org.springframework.validation.BindingResult;

import java.util.Set;

public interface UserService {

    boolean hasLoggedUser ();

    void register(UserRegisterDTO registerDTO);

    boolean login(UserLoginDTO loginDTO, BindingResult bindingResult);

    String getLoggedUsername();

    void logout();
}
