package com.blog.bloghub.post.repository;

import com.blog.bloghub.post.dto.PostInfo;
import com.blog.bloghub.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT new com.blog.bloghub.post.dto.PostInfo(p.postId, p.postTitle, p.postContent, p.postStatus, p.postIsPublic, p.allowComment)" +
    "FROM Post p WHERE p.postId = :postId")
    PostInfo findByPostId(@Param("postId") Long postId);
    @Query("SELECT new com.blog.bloghub.post.dto.PostInfo(p.postId, p.postTitle, p.postContent, p.postStatus, p.postIsPublic, p.allowComment)" +
            "FROM Post p WHERE p.blog.user.userId = :userId")
    List<PostInfo> getAllPostsByUserId (@Param("userId") String userId);
}