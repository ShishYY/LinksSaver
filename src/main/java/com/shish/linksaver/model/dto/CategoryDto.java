package com.shish.linksaver.model.dto;

public class CategoryDto {

    private String email;

    private String linkCategory;

    public CategoryDto() {
    }

    public CategoryDto(String email, String linkCategory) {
        this.email = email;
        this.linkCategory = linkCategory;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLinkCategory() {
        return linkCategory;
    }

    public void setLinkCategory(String linkCategory) {
        this.linkCategory = linkCategory;
    }
}
