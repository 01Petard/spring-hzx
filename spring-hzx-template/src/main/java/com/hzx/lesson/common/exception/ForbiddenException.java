package com.hzx.lesson.common.exception;

/**
 * @author shenzh
 */
public class ForbiddenException extends ApiException {

    public ForbiddenException() {
        super(ApiErrors.DEFAULT_MESSAGE_FORBIDDEN);
    }

    public ForbiddenException(String message) {
        super(message);
    }

    public ForbiddenException(String message, String details) {
        super(message, details);
    }
}
