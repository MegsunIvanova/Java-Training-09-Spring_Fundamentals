package bg.softuni.mobilele.service;

import bg.softuni.mobilele.model.dto.UserLoginDTO;
import bg.softuni.mobilele.model.dto.UserRegisterDTO;
import bg.softuni.mobilele.model.entity.UserEntity;

public interface UserService {

    void registerUser(UserRegisterDTO userRegisterDTO);

    boolean login(UserLoginDTO loginDTO);

    void login(UserEntity userEntity);

    void logout();
}
