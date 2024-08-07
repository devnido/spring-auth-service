package com.example.auth.app.auth.infrastructure.repository.database.mapper;

import com.example.auth.app.auth.domain.entities.User;
import com.example.auth.app.auth.infrastructure.repository.database.entities.UserDBModel;
import com.example.auth.base.annotations.Mapper;

@Mapper
public class UserMongoDBMapper {

  public User toDomain(UserDBModel dbModel) {

    User user = new User();

    user.setId(dbModel.getId());
    user.setFirstName(dbModel.getFirstName());
    user.setLastName(dbModel.getLastName());
    user.setEmail(dbModel.getEmail());
    user.setPassword(dbModel.getPassword());
    user.setVerified(dbModel.isVerified());
    user.setActive(dbModel.isActive());
    user.setCreatedAt(dbModel.getCreatedAt());
    user.setUpdatedAt(dbModel.getUpdatedAt());

    return user;
  }

  public UserDBModel toDBModel(User user) {

    UserDBModel dbModel = new UserDBModel();

    dbModel.setId(user.getId());
    dbModel.setFirstName(user.getFirstName());
    dbModel.setLastName(user.getLastName());
    dbModel.setEmail(user.getEmail());
    dbModel.setPassword(user.getPassword());
    dbModel.setVerified(user.isVerified());
    dbModel.setActive(user.isActive());
    dbModel.setCreatedAt(user.getCreatedAt());
    dbModel.setUpdatedAt(user.getUpdatedAt());

    return dbModel;
  }
}
