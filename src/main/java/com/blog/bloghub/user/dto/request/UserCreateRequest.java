package com.blog.bloghub.user.dto.request;

import com.blog.bloghub.user.entity.User;
import com.blog.bloghub.user.entity.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class UserCreateRequest {
    private String userId;
    private String userPassword;
    private String userName;
    private String userEmail;

    public User toEntity(String userPassword) {
        return User.builder()
                .userId(userId)
                .userPassword(userPassword)
                .userName(userName)
                .userEmail(userEmail)
                .userRole(UserRole.ROLE_MEMBER)
                .userCreatedAt(LocalDateTime.now())
                .build();
    }
}
