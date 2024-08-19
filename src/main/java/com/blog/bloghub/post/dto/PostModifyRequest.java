package com.blog.bloghub.post.dto;

import com.blog.bloghub.post.entity.PostStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostModifyRequest {
    private String postTitle;
    private String postContent;
    private PostStatus postStatus;
    private boolean postIsPublic;
    private boolean allowComment;
}
