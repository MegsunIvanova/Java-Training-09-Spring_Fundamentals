package com.plannerapp.model.dto;

import com.plannerapp.vallidation.FieldMatch;
import com.plannerapp.vallidation.UniqueEmail;
import com.plannerapp.vallidation.UniqueUsername;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@FieldMatch(
        first = "password",
        second = "confirmPassword",
        message = "Password do not match")
public class UserRegisterDTO {
    @NotEmpty
    @Size(min = 3, max = 20)
    @UniqueUsername(message = "This username has already taken!")
    private String username;

    @NotEmpty
    @Email
    @UniqueEmail(message = "This email has already used!")
    private String email;

    @NotEmpty
    @Size(min = 3, max = 20)
    private String password;

    @NotEmpty
    @Size(min = 3, max = 20)
    private String confirmPassword;

    public UserRegisterDTO() {
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
