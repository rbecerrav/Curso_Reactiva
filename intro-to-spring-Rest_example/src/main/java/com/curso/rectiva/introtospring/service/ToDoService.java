package com.curso.rectiva.introtospring.service;


import org.springframework.stereotype.Service;

@Service
public class ToDoService {
    private String helloWorld= "Hello Bancolombia's Team!";

    public String saludar() {
        return helloWorld;
    }

}
