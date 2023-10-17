package com.likebookapp.model.dto;

import java.util.ArrayList;
import java.util.List;

public class HomePageDTO {
    private String loggedUserUsername;
    private List<PostDTO> myPosts;
    private List<PostDTO> otherPosts;

    public HomePageDTO() {
        this.myPosts =  new ArrayList<>();
        this.otherPosts = new ArrayList<>();
    }

    public HomePageDTO(String loggedUserUsername, List<PostDTO> myPosts, List<PostDTO> otherPosts) {
        this.loggedUserUsername = loggedUserUsername;
        this.myPosts = myPosts;
        this.otherPosts = otherPosts;
    }

    public String getLoggedUserUsername() {
        return loggedUserUsername;
    }

    public HomePageDTO setLoggedUserUsername(String loggedUserUsername) {
        this.loggedUserUsername = loggedUserUsername;
        return this;
    }

    public List<PostDTO> getMyPosts() {
        return myPosts;
    }

    public HomePageDTO setMyPosts(List<PostDTO> myPosts) {
        this.myPosts = myPosts;
        return this;
    }

    public List<PostDTO> getOtherPosts() {
        return otherPosts;
    }

    public HomePageDTO setOtherPosts(List<PostDTO> otherPosts) {
        this.otherPosts = otherPosts;
        return this;
    }
}
