package com.example.pathfinder.service;

import com.example.pathfinder.model.Route;
import com.example.pathfinder.model.dto.AddRouteDTO;

public interface RouteService {
    Route getMostCommented();

    void add(AddRouteDTO routeDTO);
}
