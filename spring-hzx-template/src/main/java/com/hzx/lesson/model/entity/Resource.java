package com.hzx.lesson.model.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Resource)实体类
 * @author makejava
 * @since 2025-05-14 18:47:04
 */
public class Resource implements Serializable {
    private static final long serialVersionUID = 876156396764244320L;

    private Integer id;
    /**
     * 资源路径
     */
    private String path;
    /**
     * 角色ID
     */
    private Integer roleId;

    private Date createdAt;

    private Date updatedAt;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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

