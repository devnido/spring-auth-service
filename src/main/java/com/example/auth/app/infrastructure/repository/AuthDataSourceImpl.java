package com.example.auth.app.infrastructure.repository;

import com.example.auth.app.domain.contracts.AuthDataSource;
import com.example.auth.app.domain.entities.User;
import com.example.auth.app.infrastructure.repository.database.UserCollection;
import com.example.auth.app.infrastructure.repository.database.entities.UserDBModel;
import com.example.auth.app.infrastructure.repository.database.mapper.UserMongoDBMapper;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import org.springframework.stereotype.Repository;

@Data
@RequiredArgsConstructor
@Repository
public class AuthDataSourceImpl implements AuthDataSource {

  private final UserMongoDBMapper userMapper;

  private final UserCollection userCollection;

  @Override
  public Optional<User> findByEmail(String email) {

    Optional<UserDBModel> userDBModel = userCollection.findByEmail(email);

    if (userDBModel.isPresent()) {
      return Optional.of(userMapper.toDomain(userDBModel.get()));
    }

    return Optional.empty();
  }

  @Override
  public User save(User user) {
    UserDBModel userDBModel = userMapper.toDBModel(user);

    UserDBModel newUserSchema = userCollection.save(userDBModel);

    return userMapper.toDomain(newUserSchema);
  }

}
