package com.example.auth.app.infrastructure.tokenmanager;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.example.auth.app.domain.contracts.TokenManager;
import com.example.auth.app.domain.entities.login.token.AccessTokenPayload;
import com.example.auth.app.domain.entities.login.token.RefreshTokenPayload;
import static com.example.auth.base.config.security.constants.JwtConstants.ACCESS_TOKEN_EXPIRATION_TIME;
import static com.example.auth.base.config.security.constants.JwtConstants.SECRET_KEY;
import static com.example.auth.base.config.security.constants.JwtConstants.REFRESH_TOKEN_EXPIRATION_TIME;
import static com.example.auth.base.config.security.constants.JwtConstants.KEY_ID_PAYLOAD;
import static com.example.auth.base.config.security.constants.JwtConstants.KEY_EMAIL_PAYLOAD;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class TokenManagerImpl implements TokenManager {

  @Override
  public String generateAccessToken(AccessTokenPayload payload) {

    Claims claims = Jwts.claims()
        .add(KEY_ID_PAYLOAD, payload.getId())
        .add(KEY_EMAIL_PAYLOAD, payload.getEmail())
        .build();

    String accessToken = Jwts.builder()
        .subject(payload.getId())
        .claims(claims)
        .expiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_EXPIRATION_TIME))
        .issuedAt(new Date())
        .signWith(SECRET_KEY)
        .compact();

    return accessToken;
  }

  @Override
  public String generateRefreshToken(RefreshTokenPayload payload) {

    String refreshToken = Jwts.builder()
        .subject(payload.getId())
        .expiration(new Date(System.currentTimeMillis() + REFRESH_TOKEN_EXPIRATION_TIME))
        .issuedAt(new Date())
        .signWith(SECRET_KEY)
        .compact();

    return refreshToken;
  }

  @Override
  public boolean validateAccessToken(String token) {

    try {

      Claims claims = Jwts.parser()
          .verifyWith(SECRET_KEY)
          .build()
          .parseSignedClaims(token)
          .getPayload();

      return true;

    } catch (Exception e) {
      return false;
    }

  }

}
