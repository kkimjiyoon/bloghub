package com.blog.bloghub.file.repository;

import com.blog.bloghub.file.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}
