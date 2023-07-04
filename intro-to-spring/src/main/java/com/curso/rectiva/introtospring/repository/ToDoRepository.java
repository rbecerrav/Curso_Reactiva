package com.curso.rectiva.introtospring.repository;

import com.curso.rectiva.introtospring.repository.model.ToDo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ToDoRepository {

    private List<ToDo> list;

    public ToDoRepository(){
        list=new ArrayList<>();
    }

    public ToDo addTask(String task){
        ToDo newTask = new ToDo (task);
        list.add(newTask);
        return newTask;
    }

    public List<ToDo> getTasks(){
        return list;
    }

    public ToDo updateTask( ToDo task) {
        list.set(task.id - 1, task);
        return list.get(task.id - 1);
    }

    public void deleteTask(Integer id) {
        list.remove(id-1);
    }
}
