package com.blog.bloghub.user.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserInfoResponse {
    private String userId;
    private String userName;
    private String userEmail;
//    private String profileImageUrl;
}
