package com.blog.bloghub.blog.entity;

import com.blog.bloghub.user.entity.User;
import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Entity
@Table(name = "blog")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Blog {

    @Id
    @Column(name = "blog_id")
    private Integer blogId;

    @Setter
    @Column(name = "blog_name")
    private String blogName;

    @Column(name = "blog_address")
    private String blogAddress;

    @Setter
    @Column(name = "blog_nickname")
    private String blogNickname;

    @Setter
    @Column(name = "blog_description")
    private String blogDescription;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "blog_category_id")
    private BlogCategory blogCategory;
}
