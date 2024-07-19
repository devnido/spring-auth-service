package com.example.auth.app.domain.entities.login;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginParams {

  private String email;
  private String password;

}
