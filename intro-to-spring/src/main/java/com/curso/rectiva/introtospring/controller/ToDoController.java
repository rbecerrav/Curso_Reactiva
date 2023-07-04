package com.curso.rectiva.introtospring.controller;

import com.curso.rectiva.introtospring.repository.ToDoRepository;
import com.curso.rectiva.introtospring.repository.model.ToDo;
import com.curso.rectiva.introtospring.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/toDo")
public class ToDoController {
    @Autowired
    private ToDoService toDoService;

    @Autowired
    private ToDoRepository repo;

    @GetMapping("/helloWorld")
    public String helloWorld() {
        return toDoService.saludar();
    }

    @PostMapping("/create/task/{task}")
    public ToDo createToDo(@PathVariable("task") String task){
        return repo.addTask(task);
    }

    @GetMapping("/get/all")
    public List<ToDo> getAlTasks(){
        return repo.getTasks();
    }
    //Generar la peticion (PUT) para actualizar luna tarea ya existente
    //Generar el metodo que permite eliminar una tarea

    @PutMapping("/update/task")
    public ToDo updateTask( @RequestBody ToDo task){
        return repo.updateTask(task);
    }

    @DeleteMapping("/delete/task/{id}")
    public void deleteTask(@PathVariable("id") Integer id){
        repo.deleteTask(id);
    }


}
