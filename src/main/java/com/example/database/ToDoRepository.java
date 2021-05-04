package com.example.database;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;


public interface ToDoRepository extends CrudRepository<ToDo, Integer> {

    @Query("select DISTINCT b.name from ToDo b")
    Collection<String> findAllNames();
    @Query("select b.event from ToDo b where b.name = :name")
    Collection<String> findAllEventsByName(String name);
}
