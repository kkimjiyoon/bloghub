package com.blog.bloghub.blog.service;

import com.blog.bloghub.blog.dto.BlogCreateRequest;
import com.blog.bloghub.blog.dto.BlogInfo;
import com.blog.bloghub.blog.dto.BlogModifyRequest;

public interface BlogService {

    void createBlog(String userId, BlogCreateRequest request);

    void modifyBlog(String userId, BlogModifyRequest request);

    BlogInfo getBlog(String userId);

    void deleteBlog(String userId);
}
