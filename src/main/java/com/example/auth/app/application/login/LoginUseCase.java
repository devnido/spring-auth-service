package com.example.auth.app.application.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.auth.app.domain.contracts.AuthDataSource;
import com.example.auth.app.domain.contracts.TokenManager;
import com.example.auth.app.domain.entities.User;
import com.example.auth.app.domain.entities.login.LoginParams;
import com.example.auth.app.domain.entities.login.LoginResult;
import com.example.auth.app.domain.entities.login.token.AccessTokenPayload;
import com.example.auth.base.BaseUseCase;
import com.example.auth.base.annotations.UseCase;
import java.util.Optional;

@UseCase
public class LoginUseCase extends BaseUseCase<LoginParams, LoginResult> {

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private AuthDataSource authDataSource;

  @Autowired
  private TokenManager tokenManager;

  @Override
  public LoginResult execute(LoginParams params) {

    Optional<User> user = authDataSource.findByEmail(params.getEmail());

    if (user.isPresent() && passwordEncoder.matches(params.getPassword(), user.get().getPassword())) {

      String accessToken = tokenManager
          .generateAccessToken(new AccessTokenPayload(user.get().getId(), user.get().getEmail()));
      String refreshToken = tokenManager.generateRefreshToken();

      return new LoginResult(user.get(), accessToken, refreshToken, true);

    } else {
      return new LoginResult(false);
    }

  }

}
