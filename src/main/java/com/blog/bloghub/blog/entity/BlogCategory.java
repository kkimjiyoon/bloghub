package com.blog.bloghub.blog.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "blog_category")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BlogCategory {

    @Id
    @Column(name = "blog_category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer blogCategoryId;

    @Column(name = "blog_category_name")
    private String blogCategoryName;
}
