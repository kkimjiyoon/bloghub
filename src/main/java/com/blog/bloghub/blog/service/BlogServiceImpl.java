package com.blog.bloghub.blog.service;

import com.blog.bloghub.blog.dto.BlogCreateRequest;
import com.blog.bloghub.blog.dto.BlogInfo;
import com.blog.bloghub.blog.dto.BlogModifyRequest;
import com.blog.bloghub.blog.entity.Blog;
import com.blog.bloghub.blog.entity.BlogCategory;
import com.blog.bloghub.blog.repository.BlogCategoryRepository;
import com.blog.bloghub.blog.repository.BlogRepository;
import com.blog.bloghub.user.entity.User;
import com.blog.bloghub.user.exception.UserNotFoundException;
import com.blog.bloghub.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;
    private final UserRepository userRepository;
    private final BlogCategoryRepository blogCategoryRepository;
    @Override
    @Transactional
    public void createBlog(String userId, BlogCreateRequest request) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("회원을 찾을 수 없습니다."));
        BlogCategory blogCategory = blogCategoryRepository.findById(request.getBlogCategoryId()).orElseThrow();
        blogRepository.save(request.toEntity(user, blogCategory));

        log.info("{}의 블로그 생성 완료", user.getUserId());
    }

    @Override
    @Transactional
    public void modifyBlog(String userId, BlogModifyRequest request) {
        Blog blog = blogRepository.findByUser_UserId(userId);
        BlogCategory blogCategory = blogCategoryRepository.findById(request.getBlogCategoryId()).orElseThrow();

        blog.setBlogName(request.getBlogName());
        blog.setBlogNickname(request.getBlogNickname());
        blog.setBlogDescription(request.getBlogDescription());
        blog.setBlogCategory(blogCategory);

        blogRepository.save(blog);
    }

    @Override
    @Transactional(readOnly = true)
    public BlogInfo getBlog(String userId) {
        return blogRepository.findByUserId(userId);
    }

    @Override
    @Transactional
    public void deleteBlog(String userId) {
        Blog blog = blogRepository.findByUser_UserId(userId);
        blogRepository.delete(blog);

        log.info("{}의 블로그 삭제 완료", userId);
    }
}
