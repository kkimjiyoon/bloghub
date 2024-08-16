package com.blog.bloghub.category.service;

import com.blog.bloghub.category.dto.CategoryCreateRequest;
import com.blog.bloghub.category.dto.CategoryInfo;
import com.blog.bloghub.category.dto.CategoryModifyRequest;

import java.util.List;

public interface CategoryService {

    void createCategory(String userId, CategoryCreateRequest request);

    void modifyCategory(String userId, Long categoryId, CategoryModifyRequest request);

    List<CategoryInfo> getCategories(String userId);

    CategoryInfo getCategory(String userId, Long categoryId);

    void deleteCategory(String userId, Long categoryId);

}
