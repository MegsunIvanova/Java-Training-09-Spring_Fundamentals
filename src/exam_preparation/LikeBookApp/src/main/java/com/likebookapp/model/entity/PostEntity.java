package com.likebookapp.model.entity;

import org.springframework.data.jpa.repository.EntityGraph;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "posts")
@NamedEntityGraph(
        name = "postWithLikes",
        attributeNodes = @NamedAttributeNode("userLikes")
)
public class PostEntity extends BaseEntity {

    //content: not null, must be between 2 and 150 characters (inclusive of 2 and 150).
    @Column(nullable = false)
    private String content;

    //user: not null
    @ManyToOne(optional = false)
    private UserEntity user; //The creator of the post

    @ManyToMany
    private Set<UserEntity> userLikes;

    @ManyToOne(optional = false)
    private MoodEntity mood;

    public PostEntity() {
        this.userLikes = new HashSet<>();
    }

    public String getContent() {
        return content;
    }

    public PostEntity setContent(String content) {
        this.content = content;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public PostEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public Set<UserEntity> getUserLikes() {
        return userLikes;
    }

    public PostEntity setUserLikes(Set<UserEntity> userLikes) {
        this.userLikes = userLikes;
        return this;
    }

    public MoodEntity getMood() {
        return mood;
    }

    public PostEntity setMood(MoodEntity mood) {
        this.mood = mood;
        return this;
    }

    public PostEntity addUserLike(UserEntity user) {
        this.userLikes.add(user);
        return this;
    }
}
