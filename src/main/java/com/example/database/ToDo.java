package com.example.database;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data

public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NonNull
    @Column(unique=true)
    private String name;
    @OneToMany(mappedBy = "name", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Event> events = new ArrayList<>();

    public ToDo() {

    }

    public ToDo(String name, List<String> events) {
        this.name = name;
        for (String e:
                events) {
            var event = new Event(e);
            this.events.add(event);
            event.setName(this);
        }
    }
}
