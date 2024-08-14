package com.blog.bloghub.blog.repository;

import com.blog.bloghub.blog.dto.BlogDTO;
import com.blog.bloghub.blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
    @Query("SELECT new com.blog.bloghub.blog.dto.BlogDTO(b.blogId, b.blogName, b.blogAddress, b.blogNickname, b.blogDescription) " +
            "FROM Blog b WHERE b.user.userId = :userId")
    BlogDTO findByUserId(@Param("userId") String userId);
}
