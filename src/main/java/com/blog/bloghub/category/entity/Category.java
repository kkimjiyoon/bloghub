package com.blog.bloghub.category.entity;

import com.blog.bloghub.user.entity.User;
import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Entity
@Table(name = "category")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Setter
    @Column(name = "category_name")
    private String categoryName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
