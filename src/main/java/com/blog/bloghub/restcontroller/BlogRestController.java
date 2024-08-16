package com.blog.bloghub.restcontroller;

import com.blog.bloghub.blog.dto.BlogCreateRequest;
import com.blog.bloghub.blog.dto.BlogInfo;
import com.blog.bloghub.blog.dto.BlogModifyRequest;
import com.blog.bloghub.blog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bloghub/blog")
public class BlogRestController {

    private final BlogService blogService;

    @PostMapping("/{userId}")
    public ResponseEntity<String> createBlog(@PathVariable("userId") String userId, @RequestBody BlogCreateRequest request) {
        blogService.createBlog(userId, request);

        return ResponseEntity.status(HttpStatus.CREATED).body("블로그 생성 완료");
    }

    @PutMapping("/{userId}")
    public ResponseEntity<String> modifyBlog(@PathVariable String userId, @RequestBody BlogModifyRequest request) {
        blogService.modifyBlog(userId, request);

        return ResponseEntity.ok().body("블로그 수정 완료");
    }

    @GetMapping("/{userId}")
    public ResponseEntity<BlogInfo> getBlog(@PathVariable String userId) {
        return ResponseEntity.ok().body(blogService.getBlog(userId));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteBlog(@PathVariable String userId) {
        blogService.deleteBlog(userId);
        return ResponseEntity.ok().build();

    }
}
