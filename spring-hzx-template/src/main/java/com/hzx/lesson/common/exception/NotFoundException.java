package com.hzx.lesson.common.exception;

/**
 * @author shenzh
 */
public class NotFoundException extends ApiException {

    public NotFoundException() {
        super(ApiErrors.DEFAULT_MESSAGE_NOT_FOUND);
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, String details) {
        super(message, details);
    }
}
