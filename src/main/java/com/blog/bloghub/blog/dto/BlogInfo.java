package com.blog.bloghub.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BlogInfo {
    private Integer blogId;
    private String blogName;
    private String blogAddress;
    private String blogNickname;
    private String blogDescription;
}
