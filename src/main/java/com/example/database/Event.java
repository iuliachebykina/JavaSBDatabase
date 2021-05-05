package com.example.database;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NonNull
    private String event;
    @ManyToOne(fetch = FetchType.LAZY)
    private Name name;

    public Event(String event){
        this.event = event;
    }

    public Event() {

    }
}
