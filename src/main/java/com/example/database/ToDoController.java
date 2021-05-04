package com.example.database;


import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Data
public class ToDoController {
    final private ToDoRepository repo;
    @GetMapping("/addToDataBase/{name}/{events}")
    public void addToDo(@PathVariable String name, @PathVariable List<String> events){
        for (String event:events
             ) {
            repo.save(new ToDo(name, event));
        }
    }


    @GetMapping("/getToDoList")
    public ArrayList<ToDoList> getToDoLists(){
       var names = repo.findAllNames();
        var result = new ArrayList<ToDoList>();
        for (String name:names
        ) {
            result.add(new ToDoList(name, (List<String>) repo.findAllEventsByName(name)));
        }
        return result;
    }

}
