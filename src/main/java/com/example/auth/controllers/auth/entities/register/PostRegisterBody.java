package com.example.auth.controllers.auth.entities.register;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostRegisterBody {

  private static final int MIN_NAME_LENGTH = 2;
  private static final int MAX_NAME_LENGTH = 50;
  private static final int MIN_LAST_NAME_LENGTH = 2;
  private static final int MAX_LAST_NAME_LENGTH = 50;
  private static final int MAX_EMAIL_LENGTH = 100;
  private static final int MIN_PASSWORD_LENGTH = 6;
  private static final int MAX_PASSWORD_LENGTH = 20;
  private static final String VALID_PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[:;' \",./?]).+$";

  @NotBlank(message = "{validation.notblank.message}")
  @Size(min = MIN_NAME_LENGTH, max = MAX_NAME_LENGTH, message = "{validation.size.message}")
  String name;

  @NotBlank(message = "{validation.notblank.message}")
  @Size(min = MIN_LAST_NAME_LENGTH, max = MAX_LAST_NAME_LENGTH, message = "{validation.size.message}")
  String lastName;

  @NotBlank(message = "{validation.notblank.message}")
  @Email(message = "{validation.email.message}")
  @Size(max = MAX_EMAIL_LENGTH, message = "{validation.max.size.message}")
  String email;

  @NotBlank(message = "{validation.notblank.message}")
  @Size(min = MIN_PASSWORD_LENGTH, max = MAX_PASSWORD_LENGTH, message = "{validation.size.message}")
  @Pattern(regexp = VALID_PASSWORD_REGEX, message = "{validation.password.pattern.message}")
  String password;

}
