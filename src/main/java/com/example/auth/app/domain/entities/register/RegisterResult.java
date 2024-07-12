package com.example.auth.app.domain.entities.register;

public class RegisterResult {
  private boolean verified;
  private String email;

  public RegisterResult() {
  }

  public RegisterResult(boolean verified, String email) {
    this.verified = verified;
    this.email = email;
  }

  public boolean isVerified() {
    return verified;
  }

  public void setVerified(boolean verified) {
    this.verified = verified;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

}
