package com.shish.linksaver.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "roles")

public class RolesEntity extends AbstractEntity{


    @Column(name = "roleName")
    private String rolename;

    public RolesEntity() {
    }

    @Override
    public String toString() {
        return "RolesEntity{" +
                "rolename='" + rolename + '\'' +
                '}';
    }
}
