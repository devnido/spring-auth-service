package com.example.auth.controllers.entities.register;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostRegisterBody {

  String name;

  String lastName;

  String email;

  String password;

}
