package com.example.auth.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.auth.app.application.login.LoginUseCase;
import com.example.auth.app.application.register.RegisterUseCase;
import com.example.auth.app.domain.entities.login.LoginParams;
import com.example.auth.app.domain.entities.login.LoginResult;
import com.example.auth.app.domain.entities.register.RegisterParams;
import com.example.auth.app.domain.entities.register.RegisterResult;
import com.example.auth.controllers.entities.login.PostLoginBody;
import com.example.auth.controllers.entities.register.PostRegisterBody;
import com.example.auth.controllers.mappers.AuthMapper;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

  @Autowired
  LoginUseCase loginUseCase;

  @Autowired
  RegisterUseCase registerUseCase;

  @Autowired
  AuthMapper mapper;

  // TODO: Implement try catch block
  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody PostLoginBody body) {

    LoginParams params = mapper.toLoginParams(body);

    LoginResult result = loginUseCase.execute(params);

    if (result.isSuccess()) {
      return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "Invalid credentials"));

  }

  // TODO: Implement try catch block
  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody PostRegisterBody body) {

    RegisterParams params = mapper.toRegisterParams(body);

    RegisterResult result = registerUseCase.execute(params);

    return ResponseEntity.status(HttpStatus.OK).body(result);

  }

}
