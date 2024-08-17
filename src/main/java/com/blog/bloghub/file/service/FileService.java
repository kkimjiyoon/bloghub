package com.blog.bloghub.file.service;

import com.blog.bloghub.file.dto.FileResponse;
import com.blog.bloghub.file.entity.File;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    FileResponse saveFile(MultipartFile multipartFile, String userId);

    File getFile(Long fileId);
}
