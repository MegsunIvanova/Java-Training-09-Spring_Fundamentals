package org.softuni.reseller.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.softuni.reseller.vallidation.FieldMatch;
import org.softuni.reseller.vallidation.UniqueUserEmail;
import org.softuni.reseller.vallidation.UniqueUsername;

@FieldMatch(
        first = "password",
        second = "confirmPassword",
        message = "Password do not match"
)
public class UserRegisterDTO {

    @NotEmpty
    @Size(min = 3, max = 20)
    @UniqueUsername
    private String username;

    @Email
    @NotEmpty
    @UniqueUserEmail
    private String email;

    @NotEmpty
    @Size(min = 3, max = 20)
    private String password;

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
