package com.shish.linksaver.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "roles")

public class RolesEntity extends AbstractEntity {


    @Column(name = "role_name")
    private String roleName;

    public RolesEntity() {
    }

    @Override
    public String toString() {
        return "RolesEntity{" +
                "roleName='" + roleName + '\'' +
                '}';
    }

    public String getRolename() {
        return roleName;
    }

    public void setRolename(String rolename) {
        this.roleName = rolename;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
