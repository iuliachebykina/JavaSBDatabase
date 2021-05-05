package com.example.database;


import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Data
public class ToDoController {


    final private NameRepository nameRepository;

    @GetMapping("/addToDatabase/{name}/{events}")
    public void addToDo(@PathVariable String name, @PathVariable List<String> events) {
        var n = new Name(name);
        for (String event :
                events) {
            n.addEvent(new Event(event));
        }
        nameRepository.save(n);
    }

    @GetMapping("/getToDoLists")
    public ArrayList<ToDoList> getToDoLists() {
        var result = nameRepository.findAll();
        var r = new ArrayList<ToDoList>();
        for (Name todo :
                result) {
            r.add(new ToDoList(todo.getName(), todo.getEvents().stream().map(Event::getEvent).collect(Collectors.toList())));
            System.out.println(todo.getName());
        }
        return r;
    }
}
