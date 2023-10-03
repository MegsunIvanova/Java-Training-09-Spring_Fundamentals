package org.softuni.supermarket.repository;

import org.softuni.supermarket.model.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShopRepository extends JpaRepository<Shop, String> {

        Optional<Shop> findByAddress(String address);
}
