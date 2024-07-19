package com.example.auth.app.application.login;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.auth.app.domain.contracts.AuthDataSource;
import com.example.auth.app.domain.contracts.TokenManager;
import com.example.auth.app.domain.entities.User;
import com.example.auth.app.domain.entities.login.LoginParams;
import com.example.auth.app.domain.entities.login.LoginResult;
import com.example.auth.app.domain.entities.login.token.AccessTokenPayload;
import com.example.auth.app.domain.entities.login.token.RefreshTokenPayload;
import com.example.auth.base.BaseUseCase;
import com.example.auth.base.annotations.UseCase;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

@UseCase
@RequiredArgsConstructor
public class LoginUseCase extends BaseUseCase<LoginParams, LoginResult> {

  private final PasswordEncoder passwordEncoder;

  private final AuthDataSource authDataSource;

  private final TokenManager tokenManager;

  @Override
  public LoginResult execute(LoginParams params) {

    Optional<User> optionalUser = authDataSource.findByEmail(params.getEmail());

    if (optionalUser.isPresent() && passwordEncoder.matches(params.getPassword(), optionalUser.get().getPassword())) {

      User user = optionalUser.get();

      String accessToken = tokenManager
          .generateAccessToken(new AccessTokenPayload(user.getId(), user.getEmail()));
      String refreshToken = tokenManager.generateRefreshToken(new RefreshTokenPayload(user.getId()));

      return new LoginResult(user, accessToken, refreshToken, true);

    } else {
      return new LoginResult(false);
    }

  }

}
