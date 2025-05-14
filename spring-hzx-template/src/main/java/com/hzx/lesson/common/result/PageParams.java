package com.hzx.lesson.common.result;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分页参数
 * @author zexiao.huang
 * @since 2025-05-14 15:10:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "分页参数")
public class PageParams {

    @Schema(description = "页码", defaultValue = "1")
    private Integer pageIndex = 1;

    @Schema(description = "每页大小", defaultValue = "20")
    private Integer pageSize = 20;

    @Schema(description = "总记录数")
    private Integer from;


    /**
     * 获取偏移量
     * @return 偏移量
     */
    public Integer getFrom() {
        if (from == null) {
            from = (pageIndex - 1) * pageSize;
        }
        return from;
    }
}
