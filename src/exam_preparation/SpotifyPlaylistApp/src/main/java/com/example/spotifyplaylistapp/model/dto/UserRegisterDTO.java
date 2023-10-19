package com.example.spotifyplaylistapp.model.dto;

import com.example.spotifyplaylistapp.model.validation.FieldMatch;
import com.example.spotifyplaylistapp.model.validation.UniqueUserEmail;
import com.example.spotifyplaylistapp.model.validation.UniqueUsername;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@FieldMatch(first = "password", second = "confirmPassword", message = "Passwords not match.")
public class UserRegisterDTO {

    @UniqueUsername
    @NotEmpty(message = "Username can not be null or empty.")
    @Size(min = 3, max = 20, message = "Username length must be between 3 and 20 characters.")
    private String username;

    @UniqueUserEmail
    @NotEmpty(message = "Email can not be null or empty.")
    @Email(message = "Email must contain '@'.")
    private String email;

    //password: not null, must be between 3 and 20 characters (inclusive of 3 and 20).
    @NotEmpty(message = "Password can not be null or empty.")
    @Size(min = 3, max = 20, message = "Password length must be between 3 and 20 characters.")
    private String password;

    @NotEmpty(message = "Password can not be null or empty.")
    @Size(min = 3, max = 20, message = "Password length must be between 3 and 20 characters.")
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
