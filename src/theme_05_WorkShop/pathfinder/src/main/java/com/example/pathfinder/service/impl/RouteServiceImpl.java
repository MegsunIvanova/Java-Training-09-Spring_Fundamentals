package com.example.pathfinder.service.impl;

import com.example.pathfinder.exeptions.RouteNotFoundException;
import com.example.pathfinder.model.Picture;
import com.example.pathfinder.model.Route;
import com.example.pathfinder.model.dto.binding.AddRouteDTO;
import com.example.pathfinder.model.dto.view.RouteDetailsViewDTO;
import com.example.pathfinder.model.dto.view.RouteViewDTO;
import com.example.pathfinder.repository.CategoryRepository;
import com.example.pathfinder.repository.RouteRepository;
import com.example.pathfinder.service.RouteService;
import com.example.pathfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final CategoryRepository categoryRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public RouteServiceImpl(RouteRepository routeRepository, CategoryRepository categoryRepository, UserService userService, ModelMapper modelMapper) {
        this.routeRepository = routeRepository;
        this.categoryRepository = categoryRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public Route getMostCommented() {
        return this.routeRepository.findMostCommented();
    }

    @Override
    public void add(AddRouteDTO routeDTO) {
        Route route = modelMapper.map(routeDTO, Route.class);

        String regex = "v=(.{11})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(routeDTO.getVideoUrl());

        if (matcher.find()) {
            String videoId = matcher.group(1);
            route.setVideoUrl(videoId);
        }

        routeRepository.save(route);
    }

    @Override
    public List<RouteViewDTO> getAll() {
        return routeRepository.findAll()
                .stream()
                .map(this::getRouteObjectFunction)
                .toList();
    }

    @Override
    public RouteDetailsViewDTO getDetails(Long id) {
        Route route = routeRepository.findById(id)
                .orElseThrow(() -> new RouteNotFoundException("Route with id: " + id + " was not found!"));

        return modelMapper.map(route, RouteDetailsViewDTO.class);
    }

    private RouteViewDTO getRouteObjectFunction(Route route) {
        RouteViewDTO routeView = modelMapper.map(route, RouteViewDTO.class);
        Picture picture = route.getPictures()
                .stream()
                .findFirst()
                .orElse(null);

        routeView.setImageUrl(picture == null
                ? null
                : picture.getUrl());

        return routeView;
    }

}
