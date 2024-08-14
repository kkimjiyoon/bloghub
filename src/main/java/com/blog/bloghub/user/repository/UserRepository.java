package com.blog.bloghub.user.repository;

import com.blog.bloghub.user.dto.response.UserInfoResponse;
import com.blog.bloghub.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, String> {

    @Query("SELECT new com.blog.bloghub.user.dto.response.UserInfoResponse(u.userId, u.userName, u.userEmail)" + "FROM User u where u.userId = :userId")
    UserInfoResponse getUser(@Param("userId") String userId);
}
