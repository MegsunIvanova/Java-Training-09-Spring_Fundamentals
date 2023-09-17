package com.softuni.battleships.session;

import com.softuni.battleships.models.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class UserSession {
    private Long id;

    private String fullName;

    private boolean isLoggedIn;

    public void login(User user) {
        this.id = user.getId();
        this.fullName = user.getFullName();
        this.isLoggedIn = true;
    }

    public void logout() {
        this.id = null;
        this.fullName = null;
        this.isLoggedIn = false;
    }

    public Long getId() {
        return id;
    }

    public UserSession setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserSession setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public UserSession setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
        return this;
    }
}
