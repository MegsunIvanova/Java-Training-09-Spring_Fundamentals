package com.example.pathfinder.model;

import com.example.pathfinder.model.enums.Level;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users"
//        , uniqueConstraints = @UniqueConstraint(columnNames = {"id", "username"})
    )
//@IdClass(UserPK.class) //for composite key
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //    @Id
    @Column(nullable = false, unique = true)
    private String username; //Accepts values, which should be at least 2 characters

//    @EmbeddedId //for composite key
//    private UserPK primaryKey;

    @Column(nullable = false)
    private String password; //Accepts values, which should be at least 2 characters

    @Column(name = "full_name", nullable = false)
    private String fullName;

    private int age;

    @Column(unique = true, nullable = false)
    private String email; //Accepts values, which contain the '@' symbol

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles; //Each registered user should have a "User" role

    @Enumerated(EnumType.STRING)
    private Level level;

    public User() {
        this.roles = new HashSet<>();
    }

    public User(String username, String password, String fullName, int age, String email) {
        this();
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.age = age;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public User setId(long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public User setRoles(Set<Role> roles) {
        this.roles = roles;
        return this;
    }

    public Level getLevel() {
        return level;
    }

    public User setLevel(Level level) {
        this.level = level;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public User setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public int getAge() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }
}
