package com.blog.bloghub.blog.repository;

import com.blog.bloghub.blog.entity.BlogCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogCategoryRepository extends JpaRepository<BlogCategory, Integer> {
}
