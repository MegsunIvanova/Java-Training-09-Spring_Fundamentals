package com.plannerapp.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.management.modelmbean.ModelMBean;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class AppConfiguration {

//    @Bean
//    public ModelMapper modelMapper () {
//        ModelMapper modelMapper = new ModelMapper();
//
//        modelMapper
//                .addConverter((Converter<String, LocalDate>) mappingContext -> LocalDate
//                .parse(mappingContext.getSource(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//
//        return modelMapper;
//    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
