package com.blog.bloghub.category.service;

import com.blog.bloghub.category.dto.CategoryCreateRequest;
import com.blog.bloghub.category.dto.CategoryInfo;
import com.blog.bloghub.category.dto.CategoryModifyRequest;
import com.blog.bloghub.category.entity.Category;
import com.blog.bloghub.category.repository.CategoryRepository;
import com.blog.bloghub.user.entity.User;
import com.blog.bloghub.user.exception.UserNotFoundException;
import com.blog.bloghub.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    @Override
    @Transactional
    public void createCategory(String userId, CategoryCreateRequest request) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("회원을 찾을 수 없습니다."));
        categoryRepository.save(request.toEntity(user));
    }

    @Override
    @Transactional
    public void modifyCategory(String userId, Long categoryId, CategoryModifyRequest request) {
        Category category = categoryRepository.findByUser_UserIdAndCategoryId(userId, categoryId);
        category.setCategoryName(request.getCategoryName());

        categoryRepository.save(category);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryInfo> getCategories(String userId) {
        return categoryRepository.findByUserId(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public CategoryInfo getCategory(String userId, Long categoryId) {
        return categoryRepository.findUserCategory(userId, categoryId);
    }

    @Override
    @Transactional
    public void deleteCategory(String userId, Long categoryId) {
        Category category = categoryRepository.findByUser_UserIdAndCategoryId(userId, categoryId);
        categoryRepository.delete(category);
    }

}
