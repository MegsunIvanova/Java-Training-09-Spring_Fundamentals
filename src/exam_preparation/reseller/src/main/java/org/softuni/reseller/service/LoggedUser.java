package org.softuni.reseller.service;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class LoggedUser {
    private String username;
    private boolean isLogged;

    public void login (String username) {
        this.username = username;
        this.isLogged = true;
    }

    public void logout () {
        this.username = null;
        this.isLogged = false;
    }

    public LoggedUser() {
    }

    public String getUsername() {
        return username;
    }

    public boolean isLogged() {
        return isLogged;
    }

}
