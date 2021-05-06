package com.example.database;


import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Data
public class ToDoController {


    final private ToDoRepository nameRepository;

    /*@GetMapping("/addToDatabase/{name}/{events}")
    public void addToDo(@PathVariable String name, @PathVariable List<String> events) {
        var n = new ToDo(name, events);
        nameRepository.save(n);
    }*/

    @PostMapping("/addToDatabase")
    public void addToDo(@RequestBody ToDoList toDoList) {
        var n = new ToDo(toDoList.getName(), toDoList.getEvents());
        nameRepository.save(n);
    }

    @GetMapping("/getToDoLists")
    public ArrayList<ToDoList> getToDoLists() {
        var names = nameRepository.findAll();
        var result = new ArrayList<ToDoList>();
        for (var name :
                names) {
            result.add(new ToDoList(name.getName(), name.getEvents().stream().map(Event::getEvent).collect(Collectors.toList())));

        }
        return result;
    }
}
