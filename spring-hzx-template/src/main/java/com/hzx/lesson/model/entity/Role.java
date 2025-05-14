package com.hzx.lesson.model.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色表(Role)实体类
 * @author makejava
 * @since 2025-05-14 18:47:05
 */
public class Role implements Serializable {
    private static final long serialVersionUID = -59759753094932880L;
    /**
     * 角色ID
     */
    private Integer id;
    /**
     * 角色名
     */
    private String name;
    /**
     * 角色描述
     */
    private String description;
    /**
     * 权限等级
     */
    private String level;
    /**
     * 工厂编码
     */
    private String factoryCode;
    /**
     * 操作人ID
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getFactoryCode() {
        return factoryCode;
    }

    public void setFactoryCode(String factoryCode) {
        this.factoryCode = factoryCode;
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

