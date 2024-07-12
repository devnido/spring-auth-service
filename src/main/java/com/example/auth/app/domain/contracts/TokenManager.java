package com.example.auth.app.domain.contracts;

public interface TokenManager {

  public String generateAccessToken(String text);

  public String generateRefreshToken(String text);

}
