package com.example.auth.app.domain.contracts;

import com.example.auth.app.domain.entities.login.token.AccessTokenPayload;

public interface TokenManager {

  public String generateAccessToken(AccessTokenPayload payload);

  public String generateRefreshToken();

}
