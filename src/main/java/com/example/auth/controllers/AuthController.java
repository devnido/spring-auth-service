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

import lombok.RequiredArgsConstructor;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

  private final LoginUseCase loginUseCase;

  private final RegisterUseCase registerUseCase;

  private final AuthMapper mapper;

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody PostLoginBody body) {

    LoginParams params = mapper.loginBodyToDomain(body);

    LoginResult result = loginUseCase.execute(params);

    if (result.isSuccess()) {
      return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "Invalid credentials"));

  }

  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody PostRegisterBody body) {

    RegisterParams params = mapper.registerBodyToDomain(body);

    RegisterResult result = registerUseCase.execute(params);

    return ResponseEntity.status(HttpStatus.OK).body(result);

  }

}
