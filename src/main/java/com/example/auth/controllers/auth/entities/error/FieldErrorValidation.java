package com.example.auth.controllers.auth.entities.error;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FieldErrorValidation {

  private String field;
  private String message;

}
