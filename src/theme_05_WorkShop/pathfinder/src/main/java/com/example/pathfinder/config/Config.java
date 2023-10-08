package com.example.pathfinder.config;

import com.example.pathfinder.model.Route;
import com.example.pathfinder.model.dto.AddRouteDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;

@Configuration
public class Config {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        PropertyMap<AddRouteDTO, Route> routeMap = new PropertyMap<AddRouteDTO, Route>() {
            @Override
            protected void configure() {
                skip().setCategories(new HashSet<>());
            }
        };

        mapper.addMappings(routeMap);

        return mapper;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
