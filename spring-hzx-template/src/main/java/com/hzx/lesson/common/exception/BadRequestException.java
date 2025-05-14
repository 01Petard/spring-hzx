package com.hzx.lesson.common.exception;

/**
 * 错误请求异常
 * @author zexiao.huang
 * @since 2025-05-14 14:15:00
 */
public class BadRequestException extends RuntimeException {

    /**
     * 构造函数
     * @param message 错误消息
     */
    public BadRequestException(String message) {
        super(message);
    }
    
    /**
     * 构造函数
     * @param message 错误消息
     * @param cause 原因
     */
    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
