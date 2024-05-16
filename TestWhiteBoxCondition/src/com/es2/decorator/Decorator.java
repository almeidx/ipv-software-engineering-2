package com.es2.decorator;

import java.io.IOException;

public class Decorator implements AuthInterface {
    private final AuthInterface authInterface;

    public Decorator(AuthInterface authInterface) {
        this.authInterface = authInterface;
    }

    public void auth(String username, String password) throws AuthException, IOException {
        this.authInterface.auth(username, password);
    }
}
