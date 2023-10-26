package com.dictionaryapp.service;

import com.dictionaryapp.model.entity.UserEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class LoggedUser {

    private String username;

    public LoggedUser() {
    }

    public String getUsername() {
        return username;
    }

    public void login(UserEntity user) {
        this.username = user.getUsername();
    }

    public void logout() {
        this.username = null;
    }

    public boolean isLogged() {
        return this.username != null;
    }
}
