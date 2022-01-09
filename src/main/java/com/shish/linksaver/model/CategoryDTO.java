package com.shish.linksaver.model;

public class CategoryDTO {

    private String email;

    private String linkCategory;

    public CategoryDTO() {
    }

    public CategoryDTO(String email, String linkCategory) {
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
