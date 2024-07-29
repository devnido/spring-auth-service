package com.example.auth.controllers.auth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.auth.app.application.login.LoginUseCase;
import com.example.auth.app.application.register.RegisterUseCase;
import com.example.auth.app.domain.entities.login.LoginParams;
import com.example.auth.app.domain.entities.login.LoginResult;
import com.example.auth.app.domain.entities.register.RegisterParams;
import com.example.auth.app.domain.entities.register.RegisterResult;
import com.example.auth.controllers.auth.entities.error.ResponseFieldErrorBody;
import com.example.auth.controllers.auth.entities.login.PostLoginBody;
import com.example.auth.controllers.auth.entities.register.PostRegisterBody;
import com.example.auth.controllers.auth.mappers.AuthMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
  public ResponseEntity<?> login(@Valid @RequestBody PostLoginBody body, BindingResult bindingResult) {

    if (bindingResult.hasFieldErrors()) {
      return handleErrors(bindingResult);
    }

    LoginParams params = mapper.loginBodyToDomain(body);

    LoginResult result = loginUseCase.execute(params);

    if (result.isSuccess()) {
      return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "Invalid credentials"));

  }

  @PostMapping("/register")
  public ResponseEntity<?> register(@Valid @RequestBody PostRegisterBody body, BindingResult bindingResult) {

    if (bindingResult.hasFieldErrors()) {
      return handleErrors(bindingResult);
    }

    RegisterParams params = mapper.registerBodyToDomain(body);

    RegisterResult result = registerUseCase.execute(params);

    return ResponseEntity.status(HttpStatus.OK).body(result);

  }

  private ResponseEntity<?> handleErrors(BindingResult bindingResult) {

    ResponseFieldErrorBody body = mapper.fieldErrorsToFieldErrorResponse(bindingResult.getFieldErrors());

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
  }

}
