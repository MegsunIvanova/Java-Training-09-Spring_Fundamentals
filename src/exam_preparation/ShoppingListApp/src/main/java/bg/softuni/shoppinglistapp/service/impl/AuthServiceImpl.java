package bg.softuni.shoppinglistapp.service.impl;

import bg.softuni.shoppinglistapp.model.dto.LoginDTO;
import bg.softuni.shoppinglistapp.model.dto.RegisterDTO;
import bg.softuni.shoppinglistapp.model.entity.UserEntity;
import bg.softuni.shoppinglistapp.repository.UserRepository;
import bg.softuni.shoppinglistapp.service.AuthService;
import bg.softuni.shoppinglistapp.service.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final LoggedUser loggedUser;

    public AuthServiceImpl(ModelMapper modelMapper, PasswordEncoder passwordEncoder, UserRepository userRepository, LoggedUser loggedUser) {
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
