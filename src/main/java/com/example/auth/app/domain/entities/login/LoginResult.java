package com.example.auth.app.domain.entities.login;

import com.example.auth.app.domain.entities.User;

public class LoginResult {

  private User user;
  private String accessToken;
  private String refreshToken;
  private boolean success;

  public LoginResult() {
  }

  public LoginResult(boolean success) {
    this.success = success;
  }

  public LoginResult(User user, String accessToken, String refreshToken, boolean success) {
    this.user = user;
    this.accessToken = accessToken;
    this.refreshToken = refreshToken;
    this.success = success;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public String getRefreshToken() {
    return refreshToken;
  }

  public void setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

}
