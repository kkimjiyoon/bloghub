package com.blog.bloghub.restcontroller;

import com.blog.bloghub.user.dto.request.UserCreateRequest;
import com.blog.bloghub.user.dto.response.UserInfoResponse;
import com.blog.bloghub.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bloghub")
public class UserRestController {
    private final UserService userService;

//    public UserRestController(@Qualifier(value = "userServiceImpl") UserService userService) { // 생성자 주입 @Qualifier 설정 방법
//        this.userService = userService;
//    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserCreateRequest request) {
        userService.createUser(request);

        return ResponseEntity.status(HttpStatus.CREATED).body("회원 생성 완료");
    }

    @GetMapping("/userInfo")
    public ResponseEntity<UserInfoResponse> getUser(@RequestParam("userId") String userId) {

        return ResponseEntity.ok().body(userService.getUser(userId));
    }
    
}
