package com.blog.bloghub.post.service;

import com.blog.bloghub.post.dto.PostCreateRequest;
import com.blog.bloghub.post.dto.PostInfo;
import com.blog.bloghub.post.dto.PostModifyRequest;

import java.util.List;

public interface PostService {

    void createPost(String userId, PostCreateRequest request);

    void modifyPost(Long postId, PostModifyRequest request);

    void deletePost(Long postId);

    PostInfo getPost(Long postId);

    List<PostInfo> getPosts(String userId);
}
