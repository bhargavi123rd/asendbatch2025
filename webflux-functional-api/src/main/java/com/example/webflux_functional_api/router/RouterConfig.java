package com.example.webflux_functional_api.router;

import com.example.webflux_functional_api.handler.HelloHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> routes(HelloHandler handler) {
        return route()
                .GET("/hello", handler::hello)
                .GET("/time", handler::time)
                .build();
    }
}
