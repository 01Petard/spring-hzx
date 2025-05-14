package com.hzx.lesson.common.exception;

/**
 * @author shenzh
 */
public class UnauthorizedException extends ApiException {

    public UnauthorizedException() {
        super(ApiErrors.DEFAULT_MESSAGE_UNAUTHORIZED);
    }

    public UnauthorizedException(String message) {
        super(message);
    }

    public UnauthorizedException(String message, String details) {
        super(message, details);
    }
}
