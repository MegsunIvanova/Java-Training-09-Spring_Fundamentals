package com.softuni.battleships.services;

import com.softuni.battleships.models.Category;
import com.softuni.battleships.models.Ship;
import com.softuni.battleships.models.User;
import com.softuni.battleships.models.dtos.CreateShipDTO;
import com.softuni.battleships.models.dtos.ShipDTO;
import com.softuni.battleships.repositories.CategoryRepository;
import com.softuni.battleships.repositories.ShipRepository;
import com.softuni.battleships.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShipService {
    private final ShipRepository shipRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final AuthService authService;

    public ShipService(ShipRepository shipRepository, CategoryRepository categoryRepository,
                       UserRepository userRepository, AuthService authService) {
        this.shipRepository = shipRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.authService = authService;
    }

    public boolean create(CreateShipDTO createShipDTO) {

        Optional<Ship> byName = this.shipRepository.findByName(createShipDTO.getName());
        if (byName.isPresent()) {
            return false;
        }

        Optional<Category> category = categoryRepository.findByName(createShipDTO.getCategory());
        if (category.isEmpty()) {
            return false;
        }

        Optional<User> user = userRepository.findById(authService.getLoggedUserId());
        if (user.isEmpty()) {
            return false;
        }

        Ship ship = new Ship()
                .setName(createShipDTO.getName())
                .setPower(createShipDTO.getPower())
                .setHealth(createShipDTO.getHealth())
                .setCreated(createShipDTO.getCreated())
                .setCategory(category.get())
                .setUser(user.get());

        this.shipRepository.save(ship);

        return true;
    }

    public List<ShipDTO> getShipsOwnedBy(long ownerId) {
        return this.shipRepository.findAllByUserId(ownerId)
                .stream()
                .map(ShipDTO::new)
                .collect(Collectors.toList());
    }

    public List<ShipDTO> getShipsNotOwnedBy(long ownerId) {
        return this.shipRepository.findAllByUserIdNot(ownerId)
                .stream()
                .map(ShipDTO::new)
                .collect(Collectors.toList());
    }

    public List<ShipDTO> getSortedShips() {
        return this.shipRepository.findAllByOrderByHealthDescPowerDescNameAsc()
                .stream()
                .map(ShipDTO::new)
                .collect(Collectors.toList());
    }
}
