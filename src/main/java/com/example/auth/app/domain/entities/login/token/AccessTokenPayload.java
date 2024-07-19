package com.example.auth.app.domain.entities.login.token;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccessTokenPayload {

  private String id;
  private String email;

}
