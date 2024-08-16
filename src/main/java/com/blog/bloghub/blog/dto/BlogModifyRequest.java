package com.blog.bloghub.blog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BlogModifyRequest {
    private String blogName;
    private String blogNickname;
    private String blogDescription;
    private int blogCategoryId;
}
