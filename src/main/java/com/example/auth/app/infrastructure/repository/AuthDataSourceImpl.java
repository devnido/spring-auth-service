package com.example.auth.app.infrastructure.repository;

import com.example.auth.app.domain.contracts.AuthDataSource;
import com.example.auth.app.domain.entities.User;
import com.example.auth.app.infrastructure.repository.database.UserCollection;
import com.example.auth.app.infrastructure.repository.database.entities.UserSchema;
import com.example.auth.app.infrastructure.repository.database.mapper.UserMongoDBMapper;
import com.example.auth.base.annotations.DataSource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

@DataSource
public class AuthDataSourceImpl implements AuthDataSource {

  @Autowired
  private UserMongoDBMapper userMapper;

  @Autowired
  private UserCollection userCollection;

  @Override
  public Optional<User> findByEmail(String email) {

    Optional<UserSchema> userSchema = userCollection.findByEmail(email);

    if (userSchema.isPresent()) {
      return Optional.of(userMapper.toDomain(userSchema.get()));
    }

    return Optional.empty();
  }

  @Override
  public User save(User user) {
    UserSchema userSchema = userMapper.toSchema(user);

    UserSchema newSakterSchema = userCollection.save(userSchema);

    return userMapper.toDomain(newSakterSchema);
  }

}
