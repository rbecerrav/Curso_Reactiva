package com.santiago.posada.repository;

import com.santiago.posada.repository.model.ToDo;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ToDoRepository {

    private List<ToDo> list;

    public ToDoRepository(){
        list = new ArrayList<>();
    }

    public Mono<ToDo> addTask(String task){
        ToDo newTask = new ToDo(task);
        list.add(newTask);
        return Mono.just(newTask);
    }

    public Flux<ToDo> getTasks(){
        return Flux.fromIterable(list);
    }
}
