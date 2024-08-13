package com.blog.bloghub.blog.repository;

import com.blog.bloghub.blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
}
