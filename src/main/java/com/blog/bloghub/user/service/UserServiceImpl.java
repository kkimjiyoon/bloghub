package com.blog.bloghub.user.service;

import com.blog.bloghub.user.dto.request.UserCreateRequest;
import com.blog.bloghub.user.dto.response.UserInfoResponse;
import com.blog.bloghub.user.entity.User;
import com.blog.bloghub.user.exception.UserAlreadyExistsException;
import com.blog.bloghub.user.exception.UserNotFoundException;
import com.blog.bloghub.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

//@Primary // 우선적으로 주입시켜달라고 spring 한테 알려줌
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void createUser(UserCreateRequest request) {
        User user = userRepository.findById(request.getUserId()).orElseThrow(() -> new UserNotFoundException("회원을 찾을 수 없습니다."));
        if (Objects.nonNull(user)) {
            throw new UserAlreadyExistsException("이미 존재하는 회원입니다.");
        }
        String encodedPassword = passwordEncoder.encode(request.getUserPassword());
        User newUser = request.toEntity(encodedPassword);

        log.info("회원 생성 완료:{}", newUser.getUserId());
        userRepository.save(newUser);
    }

    @Override
    @Transactional(readOnly = true)
    public UserInfoResponse getUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("회원을 찾을 수 없습니다."));
        return userRepository.getUser(user.getUserId());
    }
}
