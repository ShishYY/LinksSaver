package com.shish.linksaver.persistence.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user", schema = "public")

public class UserEntity extends AbstractEntity {

    @OneToMany(mappedBy = "userEntityId", fetch = FetchType.LAZY)
    private final List<LinkEntity> linkEntityList = new ArrayList<>();
    @Column(name = "login")
    private String login;
    @Column(name = "name")
    private String userName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;


    public UserEntity(String login, String userName, String email, String password) {
        this.login = login;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public UserEntity() {

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "login='" + login + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
