package com.es2.factorymethod;

public class UndefinedProductException extends Exception {
    public UndefinedProductException(String message) {
        super(message);
    }
}
