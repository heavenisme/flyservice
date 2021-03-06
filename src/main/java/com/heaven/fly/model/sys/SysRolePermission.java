package com.heaven.fly.model.sys;

import javax.persistence.*;

@Table(name = "sys_role_permission")
public class SysRolePermission {
    @Id
    private Integer id;

    @Column(name = "permission_id")
    private Integer permissionId;

    @Column(name = "role_id")
    private Integer roleId;

    /**
     * @return permission_id
     */
    public Integer getPermissionId() {
        return permissionId;
    }

    /**
     * @param permissionId
     */
    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}