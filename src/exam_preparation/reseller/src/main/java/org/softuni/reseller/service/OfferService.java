package org.softuni.reseller.service;

import org.softuni.reseller.model.dto.AddOfferDTO;
import org.softuni.reseller.model.dto.HomeModelDTO;

import java.util.UUID;

public interface OfferService {

    boolean createOffer(AddOfferDTO addOfferDTO);

    void buyOffer(UUID offerId);

    void removeOffer(UUID id);

    HomeModelDTO getHomeModelDTO ();
}
