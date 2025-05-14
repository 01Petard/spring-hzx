package com.hzx.lesson.common.result;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * API返回接口
 * @author zexiao.huang
 * @since 2025-05-14 15:05:00
 */
public interface ApiReturn {

    /**
     * 返回成功响应
     * @param data 数据
     * @return 响应实体
     * @param <T> 数据类型
     */
    default <T> ResponseEntity<ApiResponse<T>> succeeded(T data) {
        return ResponseEntity.ok(ApiResponse.success(data));
    }

    /**
     * 返回成功响应（无数据）
     * @return 响应实体
     */
    default ResponseEntity<ApiResponse<OkMessage>> okResponseEntity() {
        return ResponseEntity.ok(ApiResponse.success(OkMessage.ok()));
    }

    /**
     * 返回成功响应（自定义消息）
     * @param message 消息
     * @return 响应实体
     */
    default ResponseEntity<ApiResponse<OkMessage>> okResponseEntity(String message) {
        return ResponseEntity.ok(ApiResponse.success(OkMessage.ok(message)));
    }

    /**
     * 返回失败响应
     * @param errorMessage 错误消息
     * @return 响应实体
     * @param <T> 数据类型
     */
    default <T> ResponseEntity<ApiResponse<T>> failed(ErrorMessage errorMessage) {
        return ResponseEntity.status(HttpStatus.valueOf(errorMessage.getCode()))
                .body(ApiResponse.failed(errorMessage));
    }

    /**
     * 返回失败响应
     * @param code 状态码
     * @param message 消息
     * @return 响应实体
     * @param <T> 数据类型
     */
    default <T> ResponseEntity<ApiResponse<T>> failed(int code, String message) {
        return ResponseEntity.status(HttpStatus.valueOf(code))
                .body(ApiResponse.failed(code, message));
    }
}
