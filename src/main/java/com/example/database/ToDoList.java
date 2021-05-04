package com.example.database;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class ToDoList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    private String event;

    public ToDoList(String name, String event) {
        this.name = name;
        this.event = event;
    }


    public ToDoList() {

    }
}
