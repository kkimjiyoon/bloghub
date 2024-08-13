package com.blog.bloghub.post.entity;

import com.blog.bloghub.blog.entity.Blog;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "post")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    private enum PostStatus {
        DRAFT,     // 임시저장
        PUBLISHED, // 게시됨
        ARCHIVED   // 보관됨
    }

    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    @Column(name = "post_title")
    private String postTitle;

    @Column(name = "post_content")
    private String postContent;

    @Column(name = "post_created_at")
    private LocalDateTime postCreatedAt;

    @Column(name = "post_updated_at")
    private LocalDateTime postUpdatedAt;

    @Column(name = "post_view_count")
    private Integer postViewCount;

    @Enumerated(EnumType.STRING)
    @Column(name = "post_status")
    private PostStatus postStatus;

    @Column(name = "post_isPublic")
    private boolean postIsPublic;

    @Column(name = "allow_comment")
    private boolean allowComment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "blog_id")
    private Blog blog;
}
