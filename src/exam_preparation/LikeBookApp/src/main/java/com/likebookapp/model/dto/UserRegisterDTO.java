package com.likebookapp.model.dto;

import com.likebookapp.model.validation.FieldMatch;
import com.likebookapp.model.validation.UniqueEmail;
import com.likebookapp.model.validation.UniqueUsername;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@FieldMatch(
        first = "password",
        second = "confirmPassword",
        message = "Password do not match."
)
public class UserRegisterDTO {

    @NotEmpty (message = "Username cannot be empty!")
    @Size(min=3, max =20, message = "Username length must be between 3 and 20 characters!")
    @UniqueUsername
    private String username;

    @Email
    @NotEmpty (message = "Email cannot be empty!")
    @UniqueEmail
    private String email;

    @NotEmpty (message = "Password cannot be empty!")
    @Size(min=3, max =20, message = "Password length must be between 3 and 20 characters!")
    private String password;

    @NotEmpty (message = "Password cannot be empty!")
    @Size(min=3, max =20, message = "Password length must be between 3 and 20 characters!")
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
