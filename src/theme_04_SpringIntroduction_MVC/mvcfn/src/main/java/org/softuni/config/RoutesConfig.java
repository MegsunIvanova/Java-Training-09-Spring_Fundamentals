package org.softuni.config;

import org.softuni.web.TestHandlers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.web.servlet.function.RouterFunctions.route;

@Configuration
public class RoutesConfig {

    @Bean
    public RouterFunction<ServerResponse> routerFunction(TestHandlers testHandlers) {
        return route()
                .GET("/test", testHandlers::test)
                .build();
    }
}
