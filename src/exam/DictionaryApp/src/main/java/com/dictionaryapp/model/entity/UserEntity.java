package com.dictionaryapp.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    //username: unique, not null, must be between 3 and 20 characters (inclusive of 3 and 20).
    @Column(unique = true, nullable = false) //
    private String username;

    //password: not null, must be between 3 and 20 characters (inclusive of 3 and 20).
    @Column(nullable = false)
    private String password;

    //email: unique, not null, must contain '@'.
    @Column(unique = true, nullable = false) //
    private String email;

    @OneToMany(mappedBy = "addedBy", targetEntity = WordEntity.class)
    private Set<WordEntity> addedWords;

    public UserEntity() {
        this.addedWords = new HashSet<>();
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

    public Set<WordEntity> getAddedWords() {
        return addedWords;
    }

    public UserEntity setAddedWords(Set<WordEntity> addedWords) {
        this.addedWords = addedWords;
        return this;
    }
}
