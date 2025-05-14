package com.hzx.lesson.common.exception;


/**
 * @author shenzh
 */
public class TooManyRequestsException extends ApiException {

    public TooManyRequestsException() {
        super(ApiErrors.DEFAULT_MESSAGE_TOO_MANY_REQUESTS);
    }

    public TooManyRequestsException(String message) {
        super(message);
    }

    public TooManyRequestsException(String message, String details) {
        super(message, details);
    }
}
