package com.blog.bloghub.blog.service;

import com.blog.bloghub.blog.dto.BlogCreateRequest;
import com.blog.bloghub.blog.dto.BlogInfo;
import com.blog.bloghub.blog.dto.BlogModifyRequest;
import com.blog.bloghub.blog.entity.Blog;
import com.blog.bloghub.blog.repository.BlogRepository;
import com.blog.bloghub.user.entity.User;
import com.blog.bloghub.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;
    private final UserRepository userRepository;
    @Override
    public void createBlog(String userId, BlogCreateRequest request) {
        User user = userRepository.findById(userId).orElseThrow();
        blogRepository.save(request.toEntity(user));
    }

    @Override
    public void modifyBlog(String userId, BlogModifyRequest request) {
        Blog blog = blogRepository.findById(request.getBlogId()).orElseThrow();

        blog.setBlogName(request.getBlogName());
        blog.setBlogNickname(request.getBlogNickname());
        blog.setBlogDescription(request.getBlogDescription());

        blogRepository.save(blog);
    }

    @Override
    public BlogInfo getBlog(String userId) {
        return blogRepository.findByUserId(userId);
    }

    @Override
    public void deleteBlog(String userId) {

    }
}
