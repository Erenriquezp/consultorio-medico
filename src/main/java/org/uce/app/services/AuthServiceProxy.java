package org.uce.app.services;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AuthServiceProxy implements AuthServiceInterface {

    private static final Logger LOGGER = Logger.getLogger(AuthServiceProxy.class.getName());
    private final AuthServiceInterface authService;

    public AuthServiceProxy(AuthServiceInterface authService) {
        this.authService = authService;
    }

    @Override
    public boolean authenticate(String username, String password) {
        LOGGER.log(Level.INFO, "Attempting authentication for username: {0}", username);
        boolean result = authService.authenticate(username, password);

        if (result) {
            LOGGER.log(Level.INFO, "Authentication successful for username: {0}", username);
        } else {
            LOGGER.log(Level.INFO, "Authentication failed for username: {0}", username);
        }

        return result;
    }
}
