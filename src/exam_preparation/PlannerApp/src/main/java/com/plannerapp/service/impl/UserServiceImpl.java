package com.plannerapp.service.impl;

import com.plannerapp.model.dto.TaskDTO;
import com.plannerapp.model.dto.UserLoginDTO;
import com.plannerapp.model.dto.UserRegisterDTO;
import com.plannerapp.model.entity.User;
import com.plannerapp.repo.UserRepository;
import com.plannerapp.service.UserService;
import com.plannerapp.service.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public boolean isUniqueUsername(String username) {
        return this.userRepository.findByUsername(username).isEmpty();
    }

    @Override
    public boolean isUniqueEmail(String email) {
        return this.userRepository.findByEmail(email).isEmpty();
    }

    @Override
    public void register(UserRegisterDTO registerDTO) {

        User user = modelMapper.map(registerDTO, User.class);

        String encodedPassword = passwordEncoder.encode(registerDTO.getPassword());

        user.setPassword(encodedPassword);

        userRepository.save(user);
    }

    @Override
    public boolean isExistingUser(String username, String password) {
        Optional<User> optUser = this.userRepository.findByUsername(username);

        if (optUser.isEmpty()) {
            return false;
        }

        String encodedPassword = optUser.get().getPassword();

        return passwordEncoder.matches(password, encodedPassword);
    }

    @Override
    public void login(UserLoginDTO loginDTO) {
      this.loggedUser.login(loginDTO.getUsername());
    }

    @Override
    public void logout() {
        this.loggedUser.logout();
    }

    @Override
    public String getLoggedUser() {
        return this.loggedUser.getUsername();
    }

    @Override
    @Transactional
    public List<TaskDTO> getAssignedTasks() {
        User loggedUser = userRepository
                .findByUsername(this.loggedUser.getUsername())
                .orElseThrow();

        return loggedUser.getAssignedTasks()
                .stream()
                .map(task -> modelMapper.map(task, TaskDTO.class))
                .collect(Collectors.toList());
    }


}
