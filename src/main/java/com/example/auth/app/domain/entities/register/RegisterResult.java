package com.example.auth.app.domain.entities.register;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterResult {

  private boolean verified;
  private String email;

}
