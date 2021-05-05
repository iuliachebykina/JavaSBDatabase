package com.example.database;

import lombok.Data;
import lombok.RequiredArgsConstructor;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data

public class Name {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @OneToMany(mappedBy = "name", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Event> events = new ArrayList<>();

    public Name() {

    }

    public void addEvent(Event event) {
        events.add(event);
        event.setName(this);
    }

    public Name(String name) {
        this.name = name;
    }
}
