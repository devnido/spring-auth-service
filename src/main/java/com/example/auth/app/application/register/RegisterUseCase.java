package com.example.auth.app.application.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.auth.app.domain.contracts.AuthDataSource;
import com.example.auth.app.domain.entities.User;
import com.example.auth.app.domain.entities.register.RegisterResult;
import com.example.auth.app.domain.entities.register.RegisterParams;
import com.example.auth.base.BaseUseCase;
import com.example.auth.base.annotations.UseCase;

@UseCase
public class RegisterUseCase extends BaseUseCase<RegisterParams, RegisterResult> {

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private AuthDataSource authDataSource;

  @Override
  public RegisterResult execute(RegisterParams params) {

    String encodedPassword = passwordEncoder.encode(params.getPassword());

    User user = new User(
        params.getFirstName(),
        params.getLastName(),
        params.getEmail(),
        encodedPassword);

    User newUser = authDataSource.save(user);

    RegisterResult result = new RegisterResult(
        newUser.isVerified(),
        newUser.getEmail());
    return result;
  }

}
