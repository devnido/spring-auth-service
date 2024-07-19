package com.example.auth.app.infrastructure.tokenmanager;

import java.util.Date;

import javax.crypto.SecretKey;
import org.springframework.stereotype.Component;

import com.example.auth.app.domain.contracts.TokenManager;
import com.example.auth.app.domain.entities.login.token.AccessTokenPayload;
import com.example.auth.app.domain.entities.login.token.RefreshTokenPayload;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class TokenManagerImpl implements TokenManager {

  private static final long ACCESS_TOKEN_EXPIRATION_TIME = 1000 * 60 * 2; // 2 minutes

  private static final long REFRESH_TOKEN_EXPIRATION_TIME = 1000 * 60 * 60 * 24 * 7; // 7 days

  public static final SecretKey SECRET_KEY = Jwts.SIG.HS256.key().build();

  public static final String KEY_ID = "id";

  public static final String KEY_EMAIL = "email";

  @Override
  public String generateAccessToken(AccessTokenPayload payload) {

    Claims claims = Jwts.claims()
        .add(KEY_ID, payload.getId())
        .add(KEY_EMAIL, payload.getEmail())
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

}
