package com.example.auth.controllers.entities.login;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostLoginBody {

  private String email;

  private String password;

}
