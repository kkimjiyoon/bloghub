package com.blog.bloghub.blog.entity;

import com.blog.bloghub.user.entity.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "blog")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Blog {

    @Id
    @Column(name = "blog_id")
    private Integer blogId;

    @Column(name = "blog_name")
    private String blogName;

    @Column(name = "blog_address")
    private String blogAddress;

    @Column(name = "blog_nickname")
    private String blogNickName;

    @Column(name = "blog_description")
    private String blogDescription;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
