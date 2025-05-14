package com.hzx.lesson.model.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户(User)实体类
 * @author makejava
 * @since 2025-05-14 18:47:05
 */
public class User implements Serializable {
    private static final long serialVersionUID = -72919944958875443L;
    /**
     * id
     */
    private Integer id;
    /**
     * 登录名
     */
    private String username;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 用户类型：1-admin,0-user
     */
    private Integer userType;
    /**
     * 密码
     */
    private String password;
    /**
     * 1:初始密码 0:非初始密码
     */
    private Integer initial;
    /**
     * 密码修改时间
     */
    private Integer passwordUpdateTime;
    /**
     * 最后登录时间
     */
    private Integer lastLoginTime;
    /**
     * 备注
     */
    private String memo;
    /**
     * 更新人ID
     */
    private Integer operatorId;
    /**
     * 创建时间
     */
    private Date createdAt;
    /**
     * 更新时间
     */
    private Date updatedAt;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getInitial() {
        return initial;
    }

    public void setInitial(Integer initial) {
        this.initial = initial;
    }

    public Integer getPasswordUpdateTime() {
        return passwordUpdateTime;
    }

    public void setPasswordUpdateTime(Integer passwordUpdateTime) {
        this.passwordUpdateTime = passwordUpdateTime;
    }

    public Integer getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Integer lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

}

