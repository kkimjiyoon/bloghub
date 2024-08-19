package com.blog.bloghub.post.service;

import com.blog.bloghub.blog.entity.Blog;
import com.blog.bloghub.blog.repository.BlogRepository;
import com.blog.bloghub.post.dto.PostCreateRequest;
import com.blog.bloghub.post.dto.PostInfo;
import com.blog.bloghub.post.dto.PostModifyRequest;
import com.blog.bloghub.post.entity.Post;
import com.blog.bloghub.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final BlogRepository blogRepository;

    @Override
    @Transactional
    public void createPost(String userId, PostCreateRequest request) {
        Blog blog = blogRepository.findByUser_UserId(userId);
        log.error("블로그:{}", blog.getBlogId());
        Post post = request.toEntity(blog);

        postRepository.save(post);
    }

    @Override
    @Transactional
    public void modifyPost(Long postId, PostModifyRequest request) {
        Post post = postRepository.findById(postId).orElseThrow();
        post.setPostTitle(request.getPostTitle());
        post.setPostContent(request.getPostContent());
        post.setPostUpdatedAt(LocalDateTime.now());
        post.setPostStatus(request.getPostStatus());
        post.setPostIsPublic(request.isPostIsPublic());
        post.setAllowComment(request.isAllowComment());

        postRepository.save(post);
    }

    @Override
    @Transactional
    public void deletePost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow();
        postRepository.delete(post);
    }

    @Override
    @Transactional(readOnly = true)
    public PostInfo getPost(Long postId) {
        return postRepository.findByPostId(postId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PostInfo> getPosts(String userId) {
        return postRepository.getAllPostsByUserId(userId);
    }
}
