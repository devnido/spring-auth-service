package com.example.auth.app.auth.infrastructure.repository.database;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.auth.app.auth.infrastructure.repository.database.entities.UserDBModel;
import java.util.Optional;

public interface UserRepository extends MongoRepository<UserDBModel, String> {

  public Optional<UserDBModel> findByEmail(String email);

}
