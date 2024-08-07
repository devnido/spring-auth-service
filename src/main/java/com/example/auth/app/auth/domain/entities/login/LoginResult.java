package com.example.auth.app.auth.domain.entities.login;

import com.example.auth.app.auth.domain.entities.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResult {

  private User user;
  private String accessToken;
  private String refreshToken;
  private boolean success;

  public LoginResult(boolean success) {
    this.success = success;
  }

}
