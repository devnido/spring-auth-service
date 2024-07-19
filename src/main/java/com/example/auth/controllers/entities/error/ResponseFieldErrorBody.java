package com.example.auth.controllers.entities.error;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponseFieldErrorBody {

  private List<FieldErrorValidation> errors;

}
