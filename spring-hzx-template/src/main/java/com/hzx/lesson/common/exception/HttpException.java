package com.hzx.lesson.common.exception;

/**
 * @author shenzh
 */
public class HttpException extends ApiException {
    public HttpException() {
        super(ApiErrors.DEFAULT_MESSAGE_TYPE_NETWORK_ERROR);
    }

    public HttpException(String message) {
        super(message);
    }

    public HttpException(String message, String details) {
        super(message, details);
    }
}
