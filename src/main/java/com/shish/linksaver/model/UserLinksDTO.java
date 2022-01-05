package com.shish.linksaver.model;

import java.util.List;
import java.util.Map;

public class UserLinksDTO {

    private String user;

    private List <LinkDTO> links;

    public UserLinksDTO() {
    }

    public UserLinksDTO(String user, List<LinkDTO> links) {
        this.user = user;
        this.links = links;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<LinkDTO> getLinks() {
        return links;
    }

    public void setLinks(List<LinkDTO> links) {
        this.links = links;
    }
}
