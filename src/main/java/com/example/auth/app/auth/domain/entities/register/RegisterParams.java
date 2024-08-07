package com.example.auth.app.auth.domain.entities.register;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class RegisterParams {

  private String firstName;
  private String lastName;
  private String email;
  private String password;

}
