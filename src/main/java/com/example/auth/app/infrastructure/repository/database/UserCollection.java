package com.example.auth.app.infrastructure.repository.database;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.auth.app.infrastructure.repository.database.entities.UserSchema;
import java.util.Optional;

public interface UserCollection extends MongoRepository<UserSchema, String> {

  public Optional<UserSchema> findByEmail(String email);

}
