package com.curso.rectiva.introtospring.repository.model;



public class ToDo {


    public static int counter =0;
    public int id;
    public String task;

    public ToDo(String task) {
        counter++;
        this.id=counter;
        this.task=task;
    }
    public ToDo(int id,String task){
        this.id=id;
        this.task=task;
    }

}
