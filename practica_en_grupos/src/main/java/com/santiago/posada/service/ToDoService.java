package com.santiago.posada.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ToDoService {

    private String helloWorld = "Hello World";

    public Mono<String> saludar(){
        return Mono.just(helloWorld);
    }
}
