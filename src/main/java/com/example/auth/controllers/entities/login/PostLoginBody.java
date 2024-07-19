package com.example.auth.controllers.entities.login;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostLoginBody {

  private String email;

  private String password;

}
