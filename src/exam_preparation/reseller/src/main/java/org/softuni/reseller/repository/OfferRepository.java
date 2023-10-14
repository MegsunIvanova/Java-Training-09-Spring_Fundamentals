package org.softuni.reseller.repository;

import org.softuni.reseller.model.entity.Offer;
import org.softuni.reseller.model.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OfferRepository extends JpaRepository<Offer, UUID> {

    List<Offer> findAllBySellerNotAndBuyerIsNull(User seller);

    @EntityGraph( value = "offersWithUsers", attributePaths = {"seller", "buyer"})
    @Query ("SELECT o FROM Offer o")
    List<Offer> findAllOffers ();
}
