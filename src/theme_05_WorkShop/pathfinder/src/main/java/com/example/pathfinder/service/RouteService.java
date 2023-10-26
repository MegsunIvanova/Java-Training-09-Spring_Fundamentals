package com.example.pathfinder.service;

import com.example.pathfinder.model.Route;
import com.example.pathfinder.model.dto.binding.AddRouteDTO;
import com.example.pathfinder.model.dto.view.RouteDetailsViewDTO;
import com.example.pathfinder.model.dto.view.RouteViewDTO;

import java.util.List;

public interface RouteService {
    Route getMostCommented();

    void add(AddRouteDTO routeDTO);

    List<RouteViewDTO> getAll();

    RouteDetailsViewDTO getDetails(Long id);
}
