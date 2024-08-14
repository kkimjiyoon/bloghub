package com.blog.bloghub.user.service;

import com.blog.bloghub.user.dto.request.UserCreateRequest;
import com.blog.bloghub.user.dto.response.UserInfoResponse;
import com.blog.bloghub.user.entity.User;
import com.blog.bloghub.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userService")
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void createUser(UserCreateRequest request) {
        String encodedPassword = passwordEncoder.encode(request.getUserPassword());
        User user = request.toEntity(encodedPassword);

        userRepository.save(user);
    }

    @Override
    public UserInfoResponse getUser(String userId) {

        return userRepository.getUser(userId);
    }
}
