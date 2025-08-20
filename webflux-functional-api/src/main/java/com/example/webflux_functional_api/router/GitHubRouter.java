package com.example.webflux_functional_api.router;

import com.example.webflux_functional_api.handler.GitHubHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GitHubRouter {

    @Bean
    public RouterFunction<?> routes(GitHubHandler handler) {
        return route(GET("/github/users/{username}"), handler::getUser);
    }
}
