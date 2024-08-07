package com.example.auth.app.auth.infrastructure.apiclient.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostApiResponse {
    Long id;
    Long userId;
    String title;
    String body;
}
