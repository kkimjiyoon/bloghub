package com.blog.bloghub.restcontroller;

import com.blog.bloghub.post.dto.PostCreateRequest;
import com.blog.bloghub.post.dto.PostInfo;
import com.blog.bloghub.post.dto.PostModifyRequest;
import com.blog.bloghub.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bloghub/post")
public class PostRestController {
    private final PostService postService;

    @PostMapping("/{userId}")
    public ResponseEntity<Void> createPost(@PathVariable String userId, @RequestBody PostCreateRequest request) {
        postService.createPost(userId, request);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{postId}")
    public ResponseEntity<Void> modifyPost(@PathVariable Long postId, @RequestBody PostModifyRequest request) {
        postService.modifyPost(postId, request);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostInfo> getPost(@PathVariable Long postId) {

        return ResponseEntity.ok().body(postService.getPost(postId));
    }

    @GetMapping
    public ResponseEntity<List<PostInfo>> getPosts(@RequestParam("userId") String userId) {
        return ResponseEntity.ok().body(postService.getPosts(userId));
    }
}
