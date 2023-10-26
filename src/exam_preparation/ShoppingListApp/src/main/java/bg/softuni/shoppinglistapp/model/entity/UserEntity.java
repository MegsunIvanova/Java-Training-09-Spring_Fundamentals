package bg.softuni.shoppinglistapp.model.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    //username: unique, must be between 3 and 20 characters (inclusive of 3 and 20).
    @Column(unique = true, nullable = false) //
    private String username;

    //password: must be between 3 and 20 characters (inclusive of 3 and 20).
    @Column(nullable = false)
    private String password;

    //email: unique, must contain '@'.
    @Column(unique = true) //
    private String email;

    public UserEntity() {
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

}
