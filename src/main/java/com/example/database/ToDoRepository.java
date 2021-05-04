package com.example.database;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;


public interface ToDoRepository extends CrudRepository<ToDoList, Integer> {

    @Query("select DISTINCT b.name from ToDoList b")
    Collection<String> findAllNames();
    @Query("select b.event from ToDoList b where b.name = :name")
    Collection<String> findAllEventsByName(String name);
}
