package com.shish.linksaver.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "links_category")

public class CategoryEntity extends AbstractEntity{

    @Column(name = "category_heading", length = 100)
    private String categoryHeading;

    public CategoryEntity() {
    }

    public String getCategoryHeading() {
        return categoryHeading;
    }

    public void setCategoryHeading(String categoryHeading) {
        this.categoryHeading = categoryHeading;
    }
}
