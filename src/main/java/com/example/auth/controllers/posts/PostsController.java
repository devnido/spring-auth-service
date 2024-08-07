package com.example.auth.controllers.posts;

import com.example.auth.app.posts.GetPostsUseCase;
import com.example.auth.app.posts.Post;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostsController {

  private static final Logger log = LoggerFactory.getLogger(PostsController.class);
  private final GetPostsUseCase getPostsUseCase;


  @GetMapping()
  public ResponseEntity<?> getPosts() {


    List<Post> posts = getPostsUseCase.execute();

    log.info(posts.toString());

    return ResponseEntity.accepted().body(posts);
  }

}
