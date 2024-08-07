package com.example.auth.app.auth.infrastructure.repository;

import com.example.auth.app.auth.domain.contracts.AuthDataSource;
import com.example.auth.app.auth.domain.entities.User;
import com.example.auth.app.auth.infrastructure.repository.database.UserRepository;
import com.example.auth.app.auth.infrastructure.repository.database.entities.UserDBModel;
import com.example.auth.app.auth.infrastructure.repository.database.mapper.UserMongoDBMapper;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import org.springframework.stereotype.Repository;

@Data
@RequiredArgsConstructor
@Repository
public class AuthDataSourceImpl implements AuthDataSource {

  private final UserMongoDBMapper userMapper;

  private final UserRepository userCollection;

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
