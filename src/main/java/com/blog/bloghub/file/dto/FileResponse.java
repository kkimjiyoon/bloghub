package com.blog.bloghub.file.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FileResponse {
    private Long fileId;
    private String fileName;
    private String filePath;
}
