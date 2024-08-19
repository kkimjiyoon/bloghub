package com.blog.bloghub.post.dto;

import com.blog.bloghub.post.entity.PostStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostInfo {

    private Long postId;
    private String postTitle;
    private String postContent;
    private PostStatus postStatus;
    private boolean postIsPublic;
    private boolean allowComment;
}
