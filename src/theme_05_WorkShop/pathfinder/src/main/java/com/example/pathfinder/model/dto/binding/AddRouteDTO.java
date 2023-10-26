package com.example.pathfinder.model.dto.binding;

import com.example.pathfinder.model.User;
import com.example.pathfinder.model.enums.Level;
import com.example.pathfinder.model.enums.CategoryName;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

public class AddRouteDTO {

    @NotEmpty(message = "Name cannot be empty!")
    @Size(min = 3, max = 20, message = "Name length must be between 3 and 20 characters!")
    private String name;

    @NotEmpty(message = "Description cannot be empty!")
    @Size(min = 5, message = "Description length must be more than 5 characters!")
    private String description;

//    private String gpxCoordinates;

    @NotNull
    private Level level;

//    @Size(min = 11, max = 11)
    private String videoUrl;

    private User author;

    @NotEmpty(message = "One or more category must be selected!")
    private Set<CategoryName> categories;

    public AddRouteDTO() {
        categories = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public AddRouteDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddRouteDTO setDescription(String description) {
        this.description = description;
        return this;
    }

//    public String getGpxCoordinates() {
//        return gpxCoordinates;
//    }
//
//    public AddRouteDTO setGpxCoordinates(String gpxCoordinates) {
//        this.gpxCoordinates = gpxCoordinates;
//        return this;
//    }

    public Level getLevel() {
        return level;
    }

    public AddRouteDTO setLevel(Level level) {
        this.level = level;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public AddRouteDTO setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public Set<CategoryName> getCategories() {
        return categories;
    }

    public AddRouteDTO setCategories(Set<CategoryName> categories) {
        this.categories = categories;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public AddRouteDTO setAuthor(User author) {
        this.author = author;
        return this;
    }
}
