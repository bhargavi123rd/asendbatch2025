package com.example.webflux_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class NumbersController {

    @GetMapping(value = "/numbers", produces = "text/event-stream")
    public Flux<Integer> getNumbers() {
        return Flux.range(1, 10);
    }
}
