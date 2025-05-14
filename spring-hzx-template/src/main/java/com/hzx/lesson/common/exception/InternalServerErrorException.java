package com.hzx.lesson.common.exception;

/**
 * @author shenzh
 */
public class InternalServerErrorException extends ApiException {

    public InternalServerErrorException() {
        super(ApiErrors.DEFAULT_MESSAGE_INTERNAL_SERVER_ERROR);
    }

    public InternalServerErrorException(String message) {
        super(message);
    }

    public InternalServerErrorException(String message, String details) {
        super(message, details);
    }
}
