package com.es2.memento;

public class NotExistingSnapshotException extends Exception {
    public NotExistingSnapshotException(String message) {
        super(message);
    }
}
