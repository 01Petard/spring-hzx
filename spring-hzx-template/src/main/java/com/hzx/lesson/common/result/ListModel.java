package com.hzx.lesson.common.result;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 列表模型
 * @author zexiao.huang
 * @since 2025-05-14 15:15:00
 */
@Data
@Schema(defaultValue = "分页列表")
public class ListModel<T> implements Serializable {
    @Schema(description = "总数")
    private Integer total;
    @Schema(description = "列表")
    private List<T> list;

    /**
     * 添加带有两个参数的构造函数
     */
    public ListModel(List<T> list, Integer total) {
        this.list = list;
        this.total = total;
    }
}