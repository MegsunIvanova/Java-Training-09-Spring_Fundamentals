package com.likebookapp.model.entity;

import javax.persistence.*;
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

    @OneToMany(targetEntity = PostEntity.class, mappedBy = "user", fetch= FetchType.EAGER)
    private Set<PostEntity> posts;

    public UserEntity() {
        this.posts = new HashSet<>();
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

    public Set<PostEntity> getPosts() {
        return posts;
    }

    public UserEntity setPosts(Set<PostEntity> posts) {
        this.posts = posts;
        return this;
    }

    public void addPost(PostEntity post) {
        this.posts.add(post);
    }

    public void removePost (PostEntity post) {
        this.posts.remove(post);
    }
}
