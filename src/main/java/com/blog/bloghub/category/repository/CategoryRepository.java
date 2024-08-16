package com.blog.bloghub.category.repository;

import com.blog.bloghub.category.dto.CategoryInfo;
import com.blog.bloghub.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT new com.blog.bloghub.category.dto.CategoryInfo(c.categoryId, c.categoryName)" +
    "FROM Category c WHERE c.user.userId = :userId")
    List<CategoryInfo> findByUserId(String userId);

    @Query("SELECT new com.blog.bloghub.category.dto.CategoryInfo(c.categoryId, c.categoryName)" +
            "FROM Category c WHERE c.user.userId = :userId and c.categoryId = :categoryId")
    CategoryInfo findUserCategory(String userId, Long categoryId);

    Category findByUser_UserIdAndCategoryId(String userId, Long categoryId);
}
