package com.example.auth.app.auth.domain.entities;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

  private String id;

  private String firstName;

  private String lastName;

  private String email;

  private String password;

  private boolean verified;

  private boolean active;

  private Date createdAt;

  private Date updatedAt;

  public User(String firstName, String lastName, String email, String password) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
  }

}
