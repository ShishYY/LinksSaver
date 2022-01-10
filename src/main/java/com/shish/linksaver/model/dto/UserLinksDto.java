package com.shish.linksaver.model.dto;

import java.util.List;

public class UserLinksDto {

    private String user;

    private List<LinkDto> links;

    public UserLinksDto() {
    }

    public UserLinksDto(String user, List<LinkDto> links) {
        this.user = user;
        this.links = links;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<LinkDto> getLinks() {
        return links;
    }

    public void setLinks(List<LinkDto> links) {
        this.links = links;
    }
}
