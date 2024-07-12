package com.example.auth.app.infrastructure.tokenmanager;

import org.springframework.stereotype.Component;

import com.example.auth.app.domain.contracts.TokenManager;

@Component
public class TokenManagerImpl implements TokenManager {

  @Override
  public String generateAccessToken(String text) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String generateRefreshToken(String text) {
    // TODO Auto-generated method stub
    return null;
  }

}
