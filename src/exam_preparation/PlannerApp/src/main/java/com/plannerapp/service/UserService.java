package com.plannerapp.service;

import com.plannerapp.model.dto.TaskDTO;
import com.plannerapp.model.dto.UserLoginDTO;
import com.plannerapp.model.dto.UserRegisterDTO;

import java.util.List;

public interface UserService {

    boolean hasLoggedUser();

    boolean isUniqueUsername(String username);

    boolean isUniqueEmail(String value);

    void register(UserRegisterDTO registerDTO);

    boolean isExistingUser(String username, String password);

    void login(UserLoginDTO loginDTO);

    void logout();

    String getLoggedUser();

    List<TaskDTO> getAssignedTasks();
}
