package com.hzx.lesson.common.exception;

/**
 * @author shenzh
 */
public class ApiException extends RuntimeException {

    protected final String details;
    protected int code;

    public ApiException() {
        super();
        this.details = "";
    }

    public ApiException(String message) {
        super(message);
        this.details = "";
    }

    public ApiException(String message, String details) {
        super(message);
        this.details = details;
    }

    public ApiException(String message, String details, int code) {
        super(message);
        this.details = details;
        this.code = code;
    }

    public String getDetails() {
        return details;
    }

    public int getCode() {
        return code;
    }
}
