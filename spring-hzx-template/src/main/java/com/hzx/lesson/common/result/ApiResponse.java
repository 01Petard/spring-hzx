package com.hzx.lesson.common.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * API统一响应格式
 * @author zexiao.huang
 * @since 2025-05-14 14:05:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {

    /**
     * 状态码
     */
    private int code;
    
    /**
     * 消息
     */
    private String message;
    
    /**
     * 数据
     */
    private T data;

    public static ApiResponse<OkMessage> ok() {
        return ok(OkMessage.ok());
    }

    public static <T> ApiResponse<T> ok(T data) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setData(data);
        return response;
    }

    /**
     * 成功响应
     * @param data 数据
     * @return 响应对象
     * @param <T> 数据类型
     */
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(200, "操作成功", data);
    }
    
    /**
     * 失败响应
     * @param errorMessage 错误消息
     * @return 响应对象
     */
    public static <T> ApiResponse<T> failed(ErrorMessage errorMessage) {
        return new ApiResponse<>(errorMessage.getCode(), errorMessage.getMessage(), null);
    }
    
    /**
     * 失败响应
     * @param code 状态码
     * @param message 消息
     * @return 响应对象
     */
    public static <T> ApiResponse<T> failed(int code, String message) {
        return new ApiResponse<>(code, message, null);
    }
}

