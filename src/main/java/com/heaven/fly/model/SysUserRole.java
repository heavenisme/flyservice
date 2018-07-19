package com.heaven.fly.model;

import javax.persistence.*;

@Table(name = "sys_user_role")
public class SysUserRole {
    @Id
    private Integer id;

    @Column(name = "role_id")
    private Integer roleId;

    private Integer uid;

    /**
     * @return role_id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * @return uid
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * @param uid
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}