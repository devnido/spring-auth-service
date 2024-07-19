package com.example.auth.controllers.entities.login;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostLoginBody {

  @NotBlank(message = "{validation.notblank.message}")
  @Email(message = "{validation.email.message}")
  private String email;

  @NotBlank(message = "{validation.notblank.message}")
  private String password;

}
