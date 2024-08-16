package com.blog.bloghub.restcontroller;

import com.blog.bloghub.category.dto.CategoryCreateRequest;
import com.blog.bloghub.category.dto.CategoryInfo;
import com.blog.bloghub.category.dto.CategoryModifyRequest;
import com.blog.bloghub.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bloghub/category")
public class CategoryRestController {

    private final CategoryService categoryService;

    @PostMapping("/{userId}")
    public ResponseEntity<String> createCategory(@PathVariable String userId, @RequestBody CategoryCreateRequest request) {

        categoryService.createCategory(userId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body("카테고리 생성 완료");
    }

    @PutMapping("/{userId}/{categoryId}")
    public ResponseEntity<String> modifyCategory(@PathVariable String userId,
                                                 @PathVariable Long categoryId,
                                                 @RequestBody CategoryModifyRequest request) {
        categoryService.modifyCategory(userId, categoryId, request);

        return ResponseEntity.ok().body("카테고리 수정 완료");
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<CategoryInfo>> getCategories(@PathVariable String userId) {
        return ResponseEntity.ok().body(categoryService.getCategories(userId));
    }

    @GetMapping("/{userId}/{categoryId}")
    public ResponseEntity<CategoryInfo> getCategory(@PathVariable String userId, @PathVariable Long categoryId) {
        return ResponseEntity.ok().body(categoryService.getCategory(userId, categoryId));
    }

    @DeleteMapping("/{userId}/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable String userId, @PathVariable Long categoryId) {
        categoryService.deleteCategory(userId, categoryId);

        return ResponseEntity.ok().build();
    }


}
