package com.dictionaryapp.config;

import com.dictionaryapp.model.dto.AddWordDTO;
import com.dictionaryapp.model.entity.WordEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@Configuration
public class ApplicationConfig {
    @Bean
    public ModelMapper mapper () {
        ModelMapper mapper = new ModelMapper();
        PropertyMap<AddWordDTO, WordEntity> routeMap = new PropertyMap<AddWordDTO, WordEntity>() {
            @Override
            protected void configure() {
                skip().setLanguage(null);
            }
        };

        mapper.addMappings(routeMap);

        return mapper;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new Pbkdf2PasswordEncoder();
    }
}
