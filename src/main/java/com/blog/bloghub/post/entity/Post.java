package com.blog.bloghub.post.entity;

import com.blog.bloghub.blog.entity.Blog;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Getter
@Entity
@Table(name = "post")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Setter
    @Column(name = "post_title")
    private String postTitle;

    @Setter
    @Column(name = "post_content")
    private String postContent;

    @Column(name = "post_created_at")
    private LocalDateTime postCreatedAt;

    @Setter
    @Column(name = "post_updated_at")
    private LocalDateTime postUpdatedAt;

    @Column(name = "post_view_count")
    private Integer postViewCount;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "post_status")
    private PostStatus postStatus;

    @Setter
    @Column(name = "post_is_public")
    private boolean postIsPublic;

    @Setter
    @Column(name = "allow_comment")
    private boolean allowComment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "blog_id")
    private Blog blog;
}
