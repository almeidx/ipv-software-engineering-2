package com.es2.memento;

import java.util.ArrayList;

public class Memento {
    private final ArrayList<String> studentNames;

    public Memento(ArrayList<String> studentNames) {
        this.studentNames = new ArrayList<>(studentNames);
    }

    public ArrayList<String> getState() {
        return studentNames;
    }
}
