package com.shish.linksaver.persistence.entity;

import javax.persistence.*;
//Как сделать свзять через другую таблицу?

@Entity
@Table(name = "links_category")

public class CategoryEntity extends AbstractEntity {

    @Column(name = "category_heading", length = 100)
    private String categoryHeading;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userId;

    public CategoryEntity() {
    }

    public CategoryEntity(String categoryHeading, UserEntity userId) {
        this.categoryHeading = categoryHeading;
        this.userId = userId;
    }


    public String getCategoryHeading() {
        return categoryHeading;
    }

    public void setCategoryHeading(String categoryHeading) {
        this.categoryHeading = categoryHeading;
    }

    public UserEntity getUserId() {
        return userId;
    }

    public void setUserId(UserEntity userId) {
        this.userId = userId;
    }
}
