package com.onlinebanking.userportal.domain.security;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Role {

    @Id
    private Long roleId;
    private String name;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UserRole> userRoles = new HashSet<>();


    public Role() {}


    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserRole> getUserRoleSet() {
        return userRoles;
    }

    public void setUserRoleSet(Set<UserRole> userRoleSet) {
        this.userRoles = userRoleSet;
    }
}
