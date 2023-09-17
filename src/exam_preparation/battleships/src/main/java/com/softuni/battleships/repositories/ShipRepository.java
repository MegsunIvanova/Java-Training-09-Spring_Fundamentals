package com.softuni.battleships.repositories;

import com.softuni.battleships.models.Ship;
import com.softuni.battleships.models.dtos.ShipDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {

    Optional<Ship> findByName(String name);

    List<Ship> findAllByUserId(long userId);

    List<Ship> findAllByUserIdNot(long userId);

    List<Ship> findAllByOrderByHealthDescPowerDescNameAsc();

}
