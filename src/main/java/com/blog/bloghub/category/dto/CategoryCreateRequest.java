package com.blog.bloghub.category.dto;

import com.blog.bloghub.category.entity.Category;
import com.blog.bloghub.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CategoryCreateRequest {
    private String categoryName;

    public Category toEntity(User user) {
        return Category.builder()
                .categoryName(categoryName)
                .user(user)
                .build();
    }
}
