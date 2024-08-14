package com.blog.bloghub.blog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BlogModifyRequest {
    private Integer blogId;
    private String blogName;
    private String blogNickname;
    private String blogDescription;
}
