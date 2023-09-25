package bg.softuni.mobilele.service.impl;

import bg.softuni.mobilele.model.dto.UserLoginDTO;
import bg.softuni.mobilele.model.dto.UserRegisterDTO;
import bg.softuni.mobilele.model.entity.UserEntity;
import bg.softuni.mobilele.model.mapper.UserMapper;
import bg.softuni.mobilele.repository.UserRepository;
import bg.softuni.mobilele.service.UserService;
import bg.softuni.mobilele.user.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, CurrentUser currentUser,
                           PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    @Override
    public void registerUser(UserRegisterDTO userRegisterDTO) {

        UserEntity newUser = userMapper.userDtoToUserEntity(userRegisterDTO);
        newUser.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));

        this.userRepository.save(newUser);
        login(newUser);

    }

//    private UserEntity map (UserRegisterDTO userRegisterDTO) {
//        return new UserEntity()
//                .setActive(true)
//                .setFirstName(userRegisterDTO.getFirstName())
//                .setLastName(userRegisterDTO.getLastName())
//                .setEmail(userRegisterDTO.getEmail())
//                .setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
//    }

    @Override
    public boolean login(UserLoginDTO loginDTO) {
        Optional<UserEntity> userOpt = userRepository.findByEmail(loginDTO.username());

        if (userOpt.isEmpty()) {
            LOGGER.debug("User with name [{}] not found.", loginDTO.username());
            return false;
        }

        var rawPassword = loginDTO.password();
        var encodedPassword = userOpt.get().getPassword();

        boolean success = passwordEncoder.matches(rawPassword, encodedPassword);

        if (success) {
            this.login(userOpt.get());
        } else {
            logout();
        }

        return success;
    }

    @Override
    public void login(UserEntity userEntity) {
        currentUser.setLoggedIn(true).
                setEmail(userEntity.getEmail()).
                setName(userEntity.getFirstName() + " " + userEntity.getLastName());
    }

    @Override
    public void logout() {
        currentUser.clear();
    }
}
