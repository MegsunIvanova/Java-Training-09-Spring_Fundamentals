package org.softuni.supermarket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Configuration
public class Config {

    @Bean
    public BufferedReader getReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

}
