package com.example.auth.app.infrastructure.tokenmanager;

import java.util.Date;

import javax.crypto.SecretKey;
import org.springframework.stereotype.Component;

import com.example.auth.app.domain.contracts.TokenManager;
import com.example.auth.app.domain.entities.login.token.AccessTokenPayload;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class TokenManagerImpl implements TokenManager {

  private static final long EXPIRATION_TIME = 1000 * 60 * 2; // 2 minutes

  public static final SecretKey SECRET_KEY = Jwts.SIG.HS256.key().build();

  @Override
  public String generateAccessToken(AccessTokenPayload payload) {

    Claims claims = Jwts.claims()
        .add("id", payload.getId())
        .add("email", payload.getEmail())
        .build();

    String accessToken = Jwts.builder()
        .subject(payload.getId())
        .claims(claims)
        .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
        .issuedAt(new Date())
        .signWith(SECRET_KEY)
        .compact();

    return accessToken;
  }

  @Override
  public String generateRefreshToken() {
    return "refreshToken";
  }

}
