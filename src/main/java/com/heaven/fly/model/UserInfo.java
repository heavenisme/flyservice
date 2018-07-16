package com.heaven.fly.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;

@Table(name = "user_info")
public class UserInfo implements Serializable {
    @Id
    private Integer id;

    private String phone;

    private String password;

    private String salt;

    /**
     * 角色
     */
    @Column(name = "roles_id")
    private String rolesId;

    @Column(name = "perms_id")
    private String permsId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "login_time")
    private Date loginTime;

    /**
     * 用户所有角色值，用于shiro做角色权限的判断
     */
    @Transient
    private Set<String> roles;

    /**
     * 用户所有权限值，用于shiro做资源权限的判断
     */
    @Transient
    private Set<String> perms;
    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * @return salt
     */
    public String getSalt() {
        return salt;
    }

    /**
     * @param salt
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * 获取角色
     *
     * @return roles_id - 角色
     */
    public String getRolesId() {
        return rolesId;
    }

    /**
     * 设置角色
     *
     * @param rolesId 角色
     */
    public void setRolesId(String rolesId) {
        this.rolesId = rolesId == null ? null : rolesId.trim();
    }

    /**
     * @return perms_id
     */
    public String getPermsId() {
        return permsId;
    }

    /**
     * @param permsId
     */
    public void setPermsId(String permsId) {
        this.permsId = permsId == null ? null : permsId.trim();
    }

    /**
     * @return user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * @return login_time
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * @param loginTime
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public Set<String> getPerms() {
        return perms;
    }

    public void setPerms(Set<String> perms) {
        this.perms = perms;
    }
}