package com.es2.singleton;

public class Registry extends Object {
    public static Registry instance;
    private String path;
    private String connectionString;

    private Registry() {

    }

    public static Registry getInstance() {
        if (instance == null) {
            instance = new Registry();
        }
        return instance;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getConnectionString() {
        return this.connectionString;
    }

    public void setConnectionString(String conn) {
        connectionString = conn;
    }
}
