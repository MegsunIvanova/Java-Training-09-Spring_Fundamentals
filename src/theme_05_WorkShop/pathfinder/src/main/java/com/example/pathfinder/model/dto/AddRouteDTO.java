package com.example.pathfinder.model.dto;

import com.example.pathfinder.model.enums.Level;
import com.example.pathfinder.model.enums.RouteCategory;

import java.util.HashSet;
import java.util.Set;

public class AddRouteDTO {

    private String name;

    private String description;

    private String gpxCoordinates;

    private Level level;

    private String videoUrl;

    private Set<RouteCategory> categories;

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

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public AddRouteDTO setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

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

    public Set<RouteCategory> getCategories() {
        return categories;
    }

    public AddRouteDTO setCategories(Set<RouteCategory> categories) {
        this.categories = categories;
        return this;
    }
}
