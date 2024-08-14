package com.blog.bloghub.blog.dto;

import com.blog.bloghub.blog.entity.Blog;
import com.blog.bloghub.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BlogCreateRequest {
    private String blogName;
    private String blogAddress;
    private String blogNickname;
    private String blogDescription;

    public Blog toEntity(User user) {
        return Blog.builder()
                .blogName(blogName)
                .blogAddress(blogAddress)
                .blogNickname(blogNickname)
                .blogDescription(blogDescription)
                .user(user)
                .build();
    }
}
