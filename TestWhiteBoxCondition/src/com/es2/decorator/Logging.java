package com.es2.decorator;

import java.io.IOException;

public class Logging extends Decorator {
    public Logging(AuthInterface auth) {
        super(auth);
    }

    public void auth(String username, String password) throws AuthException, IOException {
        System.out.println("Logging: auth method called with username: " + username);
        super.auth(username, password);
    }
}
