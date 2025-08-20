package com.example.webflux_functional_api.handler;

import com.example.webflux_functional_api.client.GitHubClient;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class GitHubHandler {

    private final GitHubClient gitHubClient;

    public GitHubHandler(GitHubClient gitHubClient) {
        this.gitHubClient = gitHubClient;
    }

    public Mono<ServerResponse> getUser(ServerRequest request) {
        String username = request.pathVariable("username");
        return gitHubClient.getUser(username)
                .flatMap(userJson -> ServerResponse.ok()
                        .bodyValue(userJson))
                .onErrorResume(e -> ServerResponse.badRequest()
                        .bodyValue("Error: " + e.getMessage()));
    }
}
