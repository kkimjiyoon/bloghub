package com.blog.bloghub.security;

import com.blog.bloghub.user.entity.User;
import com.blog.bloghub.user.exception.UserNotFoundException;
import com.blog.bloghub.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findById(username).orElseThrow(() -> new UserNotFoundException("해당 회원을 찾을 수 없습니다."));
        return new CustomUserDetails(user);
    }
}
