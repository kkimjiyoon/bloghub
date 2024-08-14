package com.blog.bloghub.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web -> web.ignoring().antMatchers("/assets/css/**", "/assets/js/**", "/assets/img/**", "/assets/scss/**", "/assets/vendor/**"));
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/api/bloghub/**").permitAll()
//                .antMatchers("/login").permitAll() // 로그인 페이지는 모두 접근 가능
//                .anyRequest().authenticated() // 다른 모든 요청은 인증된 사용자만 접근 가능
//                .and()
//                .formLogin()
//                .loginPage("/login") // 로그인 페이지의 URL을 설정
//                .usernameParameter("userId")
//                .passwordParameter("userPassword")
//                .permitAll() // 로그인 페이지는 모든 사용자가 접근 가능
//                .and()
//                .logout()
//                .permitAll(); // 로그아웃 페이지는 모든 사용자가 접근 가능
//
//        return http.build();

        http.csrf().disable()
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .antMatchers("/api/bloghub/**").permitAll()
//                                .antMatchers("/login").permitAll() // 로그인 페이지는 모두 접근 가능
//                                .antMatchers("/").permitAll()
//                                .anyRequest().authenticated() // 다른 모든 요청은 인증된 사용자만 접근 가능
                )
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/login") // 로그인 페이지의 URL을 설정
                                .usernameParameter("userId")
                                .passwordParameter("userPassword")
                                .defaultSuccessUrl("/", true) // 로그인 성공 후 리다이렉트할 URL
                                .permitAll() // 로그인 페이지는 모든 사용자가 접근 가능
                )
                .logout(logout ->
                        logout
                                .logoutUrl("/logout") // 로그아웃 URL 설정
                                .logoutSuccessUrl("/login?logout") // 로그아웃 성공 후 리다이렉트할 URL
                                .invalidateHttpSession(true)
                                .permitAll() // 로그아웃 페이지는 모든 사용자가 접근 가능
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
