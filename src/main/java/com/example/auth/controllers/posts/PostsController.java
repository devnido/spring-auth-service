package com.example.auth.controllers.posts;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostsController {

  @GetMapping()
  public ResponseEntity<?> getPosts() {

    return ResponseEntity.ok().body("Posts");
  }

}
