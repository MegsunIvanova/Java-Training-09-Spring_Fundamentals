package org.softuni.reseller.service;

import org.softuni.reseller.model.dto.AddOfferDTO;

public interface OfferService {

    void createOffer(AddOfferDTO addOfferDTO);

    void buyOffer(Long offerId);
}
