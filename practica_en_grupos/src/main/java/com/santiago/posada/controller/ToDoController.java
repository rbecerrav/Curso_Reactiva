package com.santiago.posada.controller;

import com.santiago.posada.repository.ToDoRepository;
import com.santiago.posada.repository.model.ToDo;
import com.santiago.posada.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/toDo")
public class ToDoController {

    @Autowired
    private ToDoService service;

    @Autowired
    private ToDoRepository repo;

    @GetMapping("/helloWorld")
    public Mono<String> helloWorld(){
        return service.saludar();
    }

    @PostMapping("/create/task/{task}")
    public Mono<ToDo> createToDo(@PathVariable("task") String task){
        return repo.addTask(task);
    }

    @GetMapping("/get/all")
    public Flux<ToDo> getAllTasks(){
        return repo.getTasks();
    }

    //Generar la petición para actualizar una tarea ya existente

    //Generar el método que permite eliminar una tarea
}
