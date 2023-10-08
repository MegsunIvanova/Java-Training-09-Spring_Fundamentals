package org.softuni.reseller.model.dto;

import org.softuni.reseller.model.entity.Offer;

import java.util.ArrayList;
import java.util.List;

public class HomeModelDTO {
    private String loggedUsername;

    private List<OfferDTO> offers;

    private List<OfferDTO> boughtOffers;

    private List<OfferDTO> otherOffers;

    public HomeModelDTO() {
        offers = new ArrayList<>();
        boughtOffers = new ArrayList<>();
        otherOffers = new ArrayList<>();
    }

    public String getLoggedUsername() {
        return loggedUsername;
    }

    public HomeModelDTO setLoggedUsername(String loggedUsername) {
        this.loggedUsername = loggedUsername;
        return this;
    }

    public List<OfferDTO> getOffers() {
        return offers;
    }

    public HomeModelDTO setOffers(List<OfferDTO> offers) {
        this.offers = offers;
        return this;
    }

    public List<OfferDTO> getBoughtOffers() {
        return boughtOffers;
    }

    public HomeModelDTO setBoughtOffers(List<OfferDTO> boughtOffers) {
        this.boughtOffers = boughtOffers;
        return this;
    }

    public List<OfferDTO> getOtherOffers() {
        return otherOffers;
    }

    public HomeModelDTO setOtherOffers(List<OfferDTO> otherOffers) {
        this.otherOffers = otherOffers;
        return this;
    }
}
