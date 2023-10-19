package com.example.spotifyplaylistapp.model.entity;

import org.springframework.data.jpa.repository.EntityGraph;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@NamedEntityGraph(name = "userWithPlaylist",
        attributeNodes = @NamedAttributeNode("playlist"))
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

    @ManyToMany
    private Set<SongEntity> playlist;

    public UserEntity() {
        this.playlist = new HashSet<>();
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

    public Set<SongEntity> getPlaylist() {
        return playlist;
    }

    public UserEntity setPlaylist(Set<SongEntity> playlist) {
        this.playlist = playlist;
        return this;
    }
}
