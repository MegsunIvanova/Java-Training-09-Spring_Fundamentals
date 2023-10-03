package org.softuni.reseller.repository;

import org.softuni.reseller.model.entity.Offer;
import org.softuni.reseller.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

    List<Offer> findAllBySellerNotAndBuyerIsNull(User seller);
}
