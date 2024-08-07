package com.example.auth.app.auth.infrastructure.apiclient.mapper;

import com.example.auth.app.posts.Post;
import com.example.auth.app.auth.infrastructure.apiclient.entities.PostApiResponse;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PostsApiMapper {
    public List<Post> mapResponseToDomain(PostApiResponse[] response){
        return Arrays.stream(response).map(post -> Post.builder()
                .Id(post.getId())
                .title(post.getTitle())
                .body(post.getBody())
                .build()).toList();
    }
}
