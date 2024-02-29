package com.es2.objectpool;

public class PoolExhaustedException extends Exception {
    public PoolExhaustedException(String message) {
        super(message);
    }
}