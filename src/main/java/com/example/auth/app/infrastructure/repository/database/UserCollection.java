package com.example.auth.app.infrastructure.repository.database;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.auth.app.infrastructure.repository.database.entities.UserDBModel;
import java.util.Optional;

public interface UserCollection extends MongoRepository<UserDBModel, String> {

  public Optional<UserDBModel> findByEmail(String email);

}
