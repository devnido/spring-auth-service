package com.example.auth.app.infrastructure.repository.database.mapper;

import com.example.auth.app.domain.entities.User;
import com.example.auth.app.infrastructure.repository.database.entities.UserSchema;
import com.example.auth.base.annotations.Mapper;

@Mapper
public class UserMongoDBMapper {

  public User toDomain(UserSchema schema) {

    User user = new User();

    user.setId(schema.getId());
    user.setFirstName(schema.getFirstName());
    user.setLastName(schema.getLastName());
    user.setEmail(schema.getEmail());
    user.setPassword(schema.getPassword());
    user.setVerified(schema.isVerified());
    user.setActive(schema.isActive());
    user.setCreatedAt(schema.getCreatedAt());
    user.setUpdatedAt(schema.getUpdatedAt());

    return user;
  }

  public UserSchema toSchema(User user) {

    UserSchema schema = new UserSchema();

    schema.setId(user.getId());
    schema.setFirstName(user.getFirstName());
    schema.setLastName(user.getLastName());
    schema.setEmail(user.getEmail());
    schema.setPassword(user.getPassword());
    schema.setVerified(user.isVerified());
    schema.setActive(user.isActive());
    schema.setCreatedAt(user.getCreatedAt());
    schema.setUpdatedAt(user.getUpdatedAt());

    return schema;
  }
}
