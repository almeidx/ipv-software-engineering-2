package com.es2.memento;

import java.util.ArrayList;

public class Server {
    private ArrayList<String> studentNames;

    public Server() {
        studentNames = new ArrayList<>();
    }

    public void addStudent(String studentName) throws ExistingStudentException {
        if (studentNames.contains(studentName)) {
            throw new ExistingStudentException("Student already exists");
        }
        studentNames.add(studentName);
    }

    public ArrayList<String> getStudentNames() {
        return studentNames;
    }

    public Memento backup() {
        return new Memento(studentNames);
    }

    public void restore(Memento m) {
        studentNames = m.getState();
    }
}
