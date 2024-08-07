package com.example.auth.app.auth.domain.contracts;

public interface AuthManager {

    void setUserAsAuthenticated(String username, String encodedPassword);

}
