package com.example.auth.app.posts;

import com.example.auth.base.BaseUseCaseNoParams;
import com.example.auth.base.annotations.UseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class GetPostsUseCase extends BaseUseCaseNoParams<List<Post>> {

    private final PostsDataSource postsDataSource;

    @Override
    public List<Post> execute() {
        return postsDataSource.getPosts();
    }
}
