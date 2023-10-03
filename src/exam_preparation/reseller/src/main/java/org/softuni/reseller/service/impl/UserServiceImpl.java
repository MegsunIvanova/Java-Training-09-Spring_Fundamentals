package org.softuni.reseller.service.impl;

import org.softuni.reseller.model.dto.UserLoginDTO;
import org.softuni.reseller.model.dto.UserRegisterDTO;
import org.softuni.reseller.model.entity.Offer;
import org.softuni.reseller.model.entity.User;
import org.softuni.reseller.repository.OfferRepository;
import org.softuni.reseller.repository.UserRepository;
import org.softuni.reseller.service.UserService;
import org.softuni.reseller.util.UserSession;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final OfferRepository offerRepository;
    private final UserSession userSession;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, OfferRepository offerRepository, UserSession userSession, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.offerRepository = offerRepository;
        this.userSession = userSession;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(UserRegisterDTO registerDTO) {
        User user = new User()
                .setUsername(registerDTO.getUsername())
                .setEmail(registerDTO.getEmail())
                .setPassword(passwordEncoder.encode(registerDTO.getPassword()));

        User saved = this.userRepository.save(user);

        System.out.println(saved);
    }

    @Override
    public boolean isUserLoggedIn() {
        return this.userSession.isLoggedIn();
    }


    @Override
    public boolean login(UserLoginDTO loginDTO) {
        Optional<User> optionalUser = this.userRepository.findByUsername(loginDTO.getUsername());

        if (optionalUser.isEmpty()) {
            return false;
        }

        User user = optionalUser.get();

        String encodedPassword = user.getPassword();
        String rawPassword = loginDTO.getPassword();

        boolean success = passwordEncoder.matches(rawPassword, encodedPassword);

        if (success) {
            List<Offer> otherOffers = this.offerRepository.findAllBySellerNotAndBuyerIsNull(user);
            userSession.login(user, otherOffers);
        }

        return success;
    }

    @Override
    public void logout() {
        this.userSession.logout();
    }


}
