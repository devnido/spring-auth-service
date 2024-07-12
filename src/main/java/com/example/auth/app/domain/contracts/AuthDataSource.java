package com.example.auth.app.domain.contracts;

import com.example.auth.app.domain.entities.User;

import java.util.Optional;

public interface AuthDataSource {
  public Optional<User> findByEmail(String email);

  public User save(User user);
}
