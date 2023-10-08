package com.example.pathfinder.service.impl;

import com.example.pathfinder.model.Category;
import com.example.pathfinder.model.Route;
import com.example.pathfinder.model.User;
import com.example.pathfinder.model.dto.AddRouteDTO;
import com.example.pathfinder.repository.CategoryRepository;
import com.example.pathfinder.repository.RouteRepository;
import com.example.pathfinder.service.RouteService;
import com.example.pathfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

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

        Set<Category> categories = this.categoryRepository
                .findByNameIn(routeDTO.getCategories());

        route.addCategories(categories);

        User author = userService.getLoggedUser();
        route.setAuthor(author);

        this.routeRepository.save(route);
    }
}
