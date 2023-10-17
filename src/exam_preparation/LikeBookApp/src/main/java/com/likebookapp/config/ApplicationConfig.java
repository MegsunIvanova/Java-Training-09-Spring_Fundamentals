package com.likebookapp.config;

import com.likebookapp.model.entity.UserEntity;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import java.util.Set;

@Configuration
public class ApplicationConfig {

    @Bean
    public ModelMapper mapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addConverter(new Converter<Set<UserEntity>, Integer>() {
            @Override
            public Integer convert(MappingContext<Set<UserEntity>, Integer> mappingContext) {
                return mappingContext.getSource().size();
            }
        });

        return modelMapper;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new Pbkdf2PasswordEncoder();
    }
}
