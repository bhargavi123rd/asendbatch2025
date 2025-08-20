package com.example.webflux_functional_api.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Component
public class HelloHandler {

    // GET /hello
    public Mono<ServerResponse> hello(ServerRequest request) {
        return ServerResponse.ok().bodyValue("Hello Functional");
    }

    // GET /time
    public Mono<ServerResponse> time(ServerRequest request) {
        return ServerResponse.ok().bodyValue(LocalDateTime.now().toString());
    }
}
