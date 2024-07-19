package com.example.auth.app.domain.entities.register;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterParams {

  private String firstName;
  private String lastName;
  private String email;
  private String password;

}
