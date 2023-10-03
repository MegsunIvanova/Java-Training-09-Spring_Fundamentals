package org.softuni.reseller.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserLoginDTO {
    @NotEmpty(message = "Username length must be between 3 and 20 characters!")
    @Size(min = 3, max = 20)
    private String username;

    @NotEmpty(message = "Password length must be between 3 and 20 characters!")
    @Size(min = 3, max = 20)
    private String password;

    public UserLoginDTO() {
    }

    public String getUsername() {
        return username;
    }

    public UserLoginDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}
