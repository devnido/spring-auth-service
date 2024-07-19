package com.example.auth.controllers.mappers;

import com.example.auth.app.domain.entities.login.LoginParams;
import com.example.auth.app.domain.entities.register.RegisterParams;
import com.example.auth.base.annotations.Mapper;
import com.example.auth.controllers.entities.error.ResponseFieldErrorBody;
import com.example.auth.controllers.entities.error.FieldErrorValidation;
import com.example.auth.controllers.entities.login.PostLoginBody;
import com.example.auth.controllers.entities.register.PostRegisterBody;

import java.util.List;

import org.springframework.validation.FieldError;

@Mapper
public class AuthMapper {

  public RegisterParams registerBodyToDomain(PostRegisterBody body) {
    return new RegisterParams(
        body.getName(),
        body.getLastName(),
        body.getEmail(),
        body.getPassword());
  }

  public LoginParams loginBodyToDomain(PostLoginBody body) {
    return new LoginParams(
        body.getEmail(),
        body.getPassword());
  }

  public ResponseFieldErrorBody fieldErrorsToFieldErrorResponse(List<FieldError> fieldErrors) {

    List<FieldErrorValidation> fieldValidationErrors = fieldErrors.stream()
        .map(fieldError -> new FieldErrorValidation(fieldError.getField(), fieldError.getDefaultMessage()))
        .toList();

    return new ResponseFieldErrorBody(fieldValidationErrors);
  }

}
