package bg.softuni.shoppinglistapp.model.dto;

import bg.softuni.shoppinglistapp.model.validation.FieldMatch;
import bg.softuni.shoppinglistapp.model.validation.UniqueUserEmail;
import bg.softuni.shoppinglistapp.model.validation.UniqueUsername;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@FieldMatch(first = "password", second = "confirmPassword", message = "Passwords not match.")
public class RegisterDTO {

    @NotEmpty(message = "Username cannot be empty.")
    @Size(min=3, max=20, message = "Username must be between 3 and 20 characters.")
    @UniqueUsername
    private String username;

    @Email(message = "Email must contain '@'.")
    @UniqueUserEmail
    private String email;

    @NotEmpty(message = "Password cannot be empty.")
    @Size(min=3, max=20, message = "Password must be between 3 and 20 characters.")
    private String password;


    @NotEmpty(message = "Password cannot be empty.")
    @Size(min=3, max=20, message = "Password must be between 3 and 20 characters.")
    private String confirmPassword;

    public RegisterDTO() {
    }

    public String getUsername() {
        return username;
    }

    public RegisterDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public RegisterDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegisterDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public RegisterDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
