package com.example.auth.app.auth.infrastructure.apiclient;

import com.example.auth.app.posts.PostsDataSource;
import com.example.auth.app.posts.Post;
import com.example.auth.app.auth.infrastructure.apiclient.mapper.PostsApiMapper;
import com.example.auth.app.auth.infrastructure.apiclient.entities.PostApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequiredArgsConstructor
@Component
public class PostsApiClient implements PostsDataSource {

    private final RestTemplate restTemplate;
    private final PostsApiMapper mapper;

    @Override
    public List<Post> getPosts() {

        String url = "https://jsonplaceholder.typicode.com/posts";

        PostApiResponse[] response = restTemplate.getForObject(url, PostApiResponse[].class);

        return mapper.mapResponseToDomain(response);
    }
}
