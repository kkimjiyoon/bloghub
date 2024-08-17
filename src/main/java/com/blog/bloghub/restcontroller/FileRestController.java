package com.blog.bloghub.restcontroller;

import com.blog.bloghub.file.dto.FileResponse;
import com.blog.bloghub.file.entity.File;
import com.blog.bloghub.file.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bloghub/file")
public class FileRestController {

    private final FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<FileResponse> uploadFile(@RequestParam("file") MultipartFile multipartFile,
                                                   @RequestParam("userId") String userId) {

        FileResponse fileResponse = fileService.saveFile(multipartFile, userId);
        return ResponseEntity.ok(fileResponse);
    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long fileId) throws IOException {
        File file = fileService.getFile(fileId);
        Path path = Paths.get(file.getFilePath());
        Resource resource = new UrlResource(path.toUri());

        // Content-Type을 파일의 실제 MIME 타입으로 설정
        MediaType contentType = MediaType.parseMediaType(Files.probeContentType(path));

        // Content-Disposition에 파일 이름 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", file.getFileName());
        headers.setContentType(contentType);

        return ResponseEntity.ok()
                .headers(headers)
                .body(resource);
    }
}
