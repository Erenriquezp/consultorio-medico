package org.uce.app.services;

public interface AuthServiceInterface {
    boolean authenticate(String username, String password);
}
