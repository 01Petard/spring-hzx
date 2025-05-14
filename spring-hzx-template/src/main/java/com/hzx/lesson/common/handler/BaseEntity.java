package com.hzx.lesson.common.handler;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.util.Date;

/**
 * 实体类通用属性
 * @author zexiao.huang
 * @since 2025-05-07 13:07:15
 */
@Data
public class BaseEntity {
    /**
     * 逻辑删除 0=未删除,1=已删除
     */
    @TableLogic
    protected Boolean deleted;

    /**
     * 创建人ID
     */
    @TableField(fill = FieldFill.INSERT)
    protected Long createId;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    protected Date createAt;

    /**
     * 修改人ID
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    protected Long updateId;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    protected Date updateAt;
}
