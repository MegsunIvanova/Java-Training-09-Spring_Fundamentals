package bg.softuni.shoppinglistapp.service;

import bg.softuni.shoppinglistapp.model.dto.LoginDTO;
import bg.softuni.shoppinglistapp.model.dto.RegisterDTO;

public interface AuthService {
    void register(RegisterDTO registerDTO);

    boolean login(LoginDTO loginDTO);

    void logout();
}
