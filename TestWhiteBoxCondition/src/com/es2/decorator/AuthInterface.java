package com.es2.decorator;

import java.io.IOException;

public interface AuthInterface {
    /**
     * Performs authentication. By default the username/password is admin/admin.
     * Parameters:
     * username - the username
     * password - the password
     * Throws:
     * AuthException - thrown when authentication fails
     * java.io.IOException - thrown when some I/O error occurs
     */
    void auth(String username, String password) throws AuthException, IOException;
}
