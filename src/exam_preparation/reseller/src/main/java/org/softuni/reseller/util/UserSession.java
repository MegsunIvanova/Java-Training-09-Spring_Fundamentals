package org.softuni.reseller.util;

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

    public void login (User user) {
        this.isLoggedIn = true;
        this.id = user.getId();
        this.username = user.getUsername();
    }

    public void logout () {
        this.isLoggedIn = false;
        this.id = null;
        this.username = null;
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

}
