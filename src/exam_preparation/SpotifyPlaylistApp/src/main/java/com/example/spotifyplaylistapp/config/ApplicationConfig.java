package com.example.spotifyplaylistapp.config;

import com.example.spotifyplaylistapp.model.dto.SongAddDTO;
import com.example.spotifyplaylistapp.model.entity.SongEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@Configuration
public class ApplicationConfig {

    @Bean
    public ModelMapper mapper() {

        ModelMapper modelMapper = new ModelMapper();
        PropertyMap<SongAddDTO, SongEntity> songMap = new PropertyMap<SongAddDTO, SongEntity>() {
            @Override
            protected void configure() {
                skip().setStyle(null);
            }
        };

        modelMapper.addMappings(songMap);

        return modelMapper;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new Pbkdf2PasswordEncoder();
    }
}
