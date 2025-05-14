package com.hzx.lesson.common.result;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 成功消息
 * @author zexiao.huang
 * @since 2025-05-14 15:00:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "成功消息")
public class OkMessage {

    @Schema(description = "消息内容")
    private String message;

    /**
     * 创建成功消息
     * @return 成功消息
     */
    public static OkMessage ok() {
        return new OkMessage("操作成功");
    }

    /**
     * 创建成功消息
     * @param message 消息内容
     * @return 成功消息
     */
    public static OkMessage ok(String message) {
        return new OkMessage(message);
    }
}
