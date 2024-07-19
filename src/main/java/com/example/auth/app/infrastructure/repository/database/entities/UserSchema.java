package com.example.auth.app.infrastructure.repository.database.entities;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Document(collection = "users")
public class UserSchema {

  private String id;

  private String firstName;

  private String lastName;

  private String email;

  private String password;

  private boolean verified;

  private boolean active;

  @CreatedDate
  private Date createdAt;

  @LastModifiedDate
  private Date updatedAt;

}
