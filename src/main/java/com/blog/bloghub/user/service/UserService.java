package com.blog.bloghub.user.service;

import com.blog.bloghub.user.dto.request.UserCreateRequest;
import com.blog.bloghub.user.dto.response.UserInfoResponse;

public interface UserService {
    void createUser(UserCreateRequest request);

    UserInfoResponse getUser(String userId);
}
