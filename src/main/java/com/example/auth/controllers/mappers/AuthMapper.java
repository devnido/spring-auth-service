package com.example.auth.controllers.mappers;

import com.example.auth.app.domain.entities.login.LoginParams;
import com.example.auth.app.domain.entities.register.RegisterParams;
import com.example.auth.base.annotations.Mapper;
import com.example.auth.controllers.entities.login.PostLoginBody;
import com.example.auth.controllers.entities.register.PostRegisterBody;

@Mapper
public class AuthMapper {

  public RegisterParams toRegisterParams(PostRegisterBody body) {
    return new RegisterParams(
        body.getName(),
        body.getLastName(),
        body.getEmail(),
        body.getPassword());
  }

  public LoginParams toLoginParams(PostLoginBody body) {
    return new LoginParams(
        body.getEmail(),
        body.getPassword());
  }

}
