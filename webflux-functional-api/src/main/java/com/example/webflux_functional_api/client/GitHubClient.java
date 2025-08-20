package com.example.webflux_functional_api.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class GitHubClient {

    private final WebClient webClient;

    public GitHubClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("https://api.github.com").build();
    }

    public Mono<String> getUser(String username) {
        return webClient.get()
                .uri("/users/{username}", username)
                .retrieve()
                .bodyToMono(String.class);
    }
}
