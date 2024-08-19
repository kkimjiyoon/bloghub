package com.blog.bloghub.post.dto;

import com.blog.bloghub.blog.entity.Blog;
import com.blog.bloghub.post.entity.Post;
import com.blog.bloghub.post.entity.PostStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostCreateRequest {
    private String postTitle;
    private String postContent;
    private PostStatus postStatus;
    private boolean postIsPublic;
    private boolean allowComment;

    public Post toEntity(Blog blog) {
        return Post.builder()
                .postTitle(postTitle)
                .postContent(postContent)
                .postCreatedAt(LocalDateTime.now())
                .postViewCount(0)
                .postStatus(postStatus)
                .postIsPublic(postIsPublic)
                .allowComment(allowComment)
                .blog(blog)
                .build();
    }
}
