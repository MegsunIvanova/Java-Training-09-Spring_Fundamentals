package org.softuni.reseller.service;

import org.softuni.reseller.model.dto.HomeModelDTO;
import org.softuni.reseller.model.dto.UserLoginDTO;
import org.softuni.reseller.model.dto.UserRegisterDTO;

public interface UserService {
    void register (UserRegisterDTO registerDTO);

    boolean isUserLoggedIn();

    HomeModelDTO createHomeModelDTO();

    void logout();

    boolean login(UserLoginDTO loginDTO);

}
