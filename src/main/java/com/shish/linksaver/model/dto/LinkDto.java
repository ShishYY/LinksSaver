package com.shish.linksaver.model.dto;

public class LinkDto {

    private String email;
    private String linkUrl;
    private String linkCategory;

    public LinkDto(String email, String linkUrl, String linkCategory) {
        this.email = email;
        this.linkUrl = linkUrl;
        this.linkCategory = linkCategory;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getLinkCategory() {
        return linkCategory;
    }

    public void setLinkCategory(String linkCategory) {
        this.linkCategory = linkCategory;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
