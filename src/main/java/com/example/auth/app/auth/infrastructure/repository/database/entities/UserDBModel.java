package com.example.auth.app.auth.infrastructure.repository.database.entities;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class UserDBModel {

  private String id;

  private String firstName;

  private String lastName;

  @Indexed(unique = true)
  private String email;

  private String password;

  private boolean verified;

  private boolean active;

  @CreatedDate
  private Date createdAt;

  @LastModifiedDate
  private Date updatedAt;

}
