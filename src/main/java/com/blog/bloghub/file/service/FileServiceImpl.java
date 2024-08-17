package com.blog.bloghub.file.service;

import com.blog.bloghub.file.dto.FileResponse;
import com.blog.bloghub.file.entity.File;
import com.blog.bloghub.file.repository.FileRepository;
import com.blog.bloghub.user.entity.User;
import com.blog.bloghub.user.exception.UserNotFoundException;
import com.blog.bloghub.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final FileRepository fileRepository;
    private final UserRepository userRepository;
    @Override
    public FileResponse saveFile(MultipartFile multipartFile, String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("회원을 찾을 수 없습니다."));

        String fileName = UUID.randomUUID() + "_" + multipartFile.getOriginalFilename();
        String filePath = "src/main/java/com/blog/bloghub/file/upload/" + fileName;

        try {
            Path path = Paths.get(filePath);
            // 파일을 UTF-8로 저장
            if (multipartFile.getContentType() != null && multipartFile.getContentType().equals("text/plain")) {
                String content = new String(multipartFile.getBytes(), StandardCharsets.UTF_8);
                Files.write(path, content.getBytes(StandardCharsets.UTF_8));
            } else {
                // 다른 형식의 파일은 그대로 저장
                Files.write(path, multipartFile.getBytes());
            }

            File file = new File();
            file.setFileName(fileName);
            file.setFileSize((int)multipartFile.getSize());
            file.setFilePath(filePath);
            file.setUser(user);

            log.error("파일:{}", multipartFile.getContentType());

            if(multipartFile.getContentType() != null && multipartFile.getContentType().startsWith("image/")) {

                BufferedImage image = ImageIO.read(multipartFile.getInputStream());
                file.setImageWidth(image.getWidth());
                file.setImageHeight(image.getHeight());
            }

            File savedFile = fileRepository.save(file);

            return new FileResponse(savedFile.getFileId(), savedFile.getFileName(), savedFile.getFilePath());

        } catch (IOException e) {
            throw new RuntimeException("파일을 저장하는 데 실패하였습니다.", e);
        }
    }

    @Override
    public File getFile(Long fileId) {
        return fileRepository.findById(fileId).orElseThrow(() -> new RuntimeException("File not found"));
    }
}
