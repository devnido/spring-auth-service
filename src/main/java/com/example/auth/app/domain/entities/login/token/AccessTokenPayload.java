package com.example.auth.app.domain.entities.login.token;

public class AccessTokenPayload {

  private String id;
  private String email;

  public AccessTokenPayload() {
  }

  public AccessTokenPayload(String id, String email) {
    this.id = id;
    this.email = email;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

}
