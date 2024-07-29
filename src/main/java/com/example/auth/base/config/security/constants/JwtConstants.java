package com.example.auth.base.config.security.constants;

import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;

public class JwtConstants {

  public static final SecretKey SECRET_KEY = Jwts.SIG.HS256.key().build();
  public static final String AUTHORIZATION_HEADER = "Authorization";
  public static final String BEARER_PREFIX = "Bearer ";
  public static final long ACCESS_TOKEN_EXPIRATION_TIME = 1000 * 60 * 2; // 2 minutes
  public static final long REFRESH_TOKEN_EXPIRATION_TIME = 1000 * 60 * 60 * 24 * 7; // 7 days
  public static final String KEY_ID_PAYLOAD = "id";
  public static final String KEY_EMAIL_PAYLOAD = "email";

}
