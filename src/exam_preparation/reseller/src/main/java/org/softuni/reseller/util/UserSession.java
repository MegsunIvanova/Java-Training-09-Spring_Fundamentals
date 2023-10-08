package org.softuni.reseller.util;

import org.softuni.reseller.model.entity.Offer;
import org.softuni.reseller.model.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@Component
@SessionScope
public class UserSession {

    private boolean isLoggedIn;
    private Long id;

    private String username;

//    private List<Offer> offers;
//
//    private List<Offer> boughtOffers;
//
//    private List<Offer> otherOffers;


    public void login (User user) {
        this.isLoggedIn = true;
        this.id = user.getId();
        this.username = user.getUsername();
//        this.offers = user.getOffers();
//        this.boughtOffers = user.getBoughtOffers();
//        this.otherOffers = otherOffers;
    }

    public void logout () {
        this.isLoggedIn = false;
        this.id = null;
        this.username = null;
//        this.offers = null;
//        this.boughtOffers = null;
//        this.otherOffers = null;
    }

    public UserSession() {
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public UserSession setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
        return this;
    }

    public Long getId() {
        return id;
    }

    public UserSession setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserSession setUsername(String username) {
        this.username = username;
        return this;
    }

//    public List<Offer> getOffers() {
//        return offers;
//    }
//
//    public UserSession setOffers(List<Offer> offers) {
//        this.offers = offers;
//        return this;
//    }

//    public List<Offer> getBoughtOffers() {
//        return boughtOffers;
//    }
//
//    public UserSession setBoughtOffers(List<Offer> boughtOffers) {
//        this.boughtOffers = boughtOffers;
//        return this;
//    }
//
//    public List<Offer> getOtherOffers() {
//        return otherOffers;
//    }
//
//    public UserSession setOtherOffers(List<Offer> otherOffers) {
//        this.otherOffers = otherOffers;
//        return this;
//    }
}
