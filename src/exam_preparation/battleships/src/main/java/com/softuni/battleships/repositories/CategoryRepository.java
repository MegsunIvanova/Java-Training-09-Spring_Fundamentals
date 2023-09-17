package com.softuni.battleships.repositories;

import com.softuni.battleships.models.Category;
import com.softuni.battleships.models.enums.ShipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository <Category, Long> {

    Optional<Category> findByName(ShipType name);
}
