package com.example.auth.app.auth.domain.contracts;

import com.example.auth.app.auth.domain.entities.login.token.AccessTokenPayload;
import com.example.auth.app.auth.domain.entities.login.token.RefreshTokenPayload;

public interface TokenManager {

  public String generateAccessToken(AccessTokenPayload payload);

  public String generateRefreshToken(RefreshTokenPayload payload);

  public boolean validateAccessToken(String token);

}
