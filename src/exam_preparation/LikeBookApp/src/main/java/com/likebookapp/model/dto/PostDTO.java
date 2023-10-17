package com.likebookapp.model.dto;

public class PostDTO {
    private Long id;

    private String userUsername;

    private String moodName;

    private Integer userLikes;

    private String content;

    public PostDTO() {
    }

    public Long getId() {
        return id;
    }

    public PostDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public PostDTO setUserUsername(String userUsername) {
        this.userUsername = userUsername;
        return this;
    }

    public String getMoodName() {
        return moodName;
    }

    public PostDTO setMoodName(String moodName) {
        this.moodName = moodName;
        return this;
    }

    public Integer getUserLikes() {
        return userLikes;
    }

    public PostDTO setUserLikes(Integer userLikes) {
        this.userLikes = userLikes;
        return this;
    }

    public String getContent() {
        return content;
    }

    public PostDTO setContent(String content) {
        this.content = content;
        return this;
    }
}
