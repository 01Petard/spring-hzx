package com.hzx.lesson.common.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzx.lesson.common.exception.ApiErrors;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author shenzh
 */
@Getter
@Setter
public class ErrorMessage {

    private int code = -1;

    @JsonProperty("error")
    private String type;

    @JsonProperty("msg")
    private String message;

    @JsonProperty("error_description")
    private String details = "";

    public static ErrorMessage badRequest() {
        return badRequest(ApiErrors.DEFAULT_MESSAGE_BAD_REQUEST);
    }

    public static ErrorMessage badRequest(String message) {
        return badRequest(message, "");
    }

    public static ErrorMessage badRequest(String message, String details) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setType(ApiErrors.TYPE_BAD_REQUEST);
        errorMessage.setMessage(message);
        errorMessage.setDetails(details);
        return errorMessage;
    }

    public static ErrorMessage badRequest(String message, String details, int code) {
        ErrorMessage errorMessage = badRequest(message, details);
        errorMessage.setCode(code);
        return errorMessage;
    }

    public static ErrorMessage unauthorized() {
        return unauthorized(ApiErrors.DEFAULT_MESSAGE_UNAUTHORIZED);
    }

    public static ErrorMessage unauthorized(String message) {
        return unauthorized(message, "");
    }

    public static ErrorMessage unauthorized(String message, String details) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setType(ApiErrors.TYPE_UNAUTHORIZED);
        errorMessage.setMessage(message);
        errorMessage.setDetails(details);
        return errorMessage;
    }

    public static ErrorMessage unauthorized(String message, String details, int code) {
        ErrorMessage errorMessage = unauthorized(message, details);
        errorMessage.setCode(code);
        return errorMessage;
    }

    public static ErrorMessage forbidden() {
        return forbidden(ApiErrors.DEFAULT_MESSAGE_FORBIDDEN);
    }

    public static ErrorMessage forbidden(String message) {
        return forbidden(message, "");
    }

    public static ErrorMessage forbidden(String message, String details) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setType(ApiErrors.TYPE_FORBIDDEN);
        errorMessage.setMessage(message);
        errorMessage.setDetails(details);
        return errorMessage;
    }

    public static ErrorMessage notFound() {
        return notFound(ApiErrors.DEFAULT_MESSAGE_NOT_FOUND);
    }

    public static ErrorMessage notFound(String message) {
        return notFound(message, "");
    }

    public static ErrorMessage notFound(String message, String details) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setType(ApiErrors.TYPE_NOT_FOUND);
        errorMessage.setMessage(message);
        errorMessage.setDetails(details);
        return errorMessage;
    }

    public static ErrorMessage methodNotAllowed() {
        return methodNotAllowed(ApiErrors.DEFAULT_MESSAGE_METHOD_NOT_ALLOWED);
    }

    public static ErrorMessage methodNotAllowed(String message) {
        return methodNotAllowed(message, "");
    }

    public static ErrorMessage methodNotAllowed(String message, String details) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setType(ApiErrors.TYPE_METHOD_NOT_ALLOWED);
        errorMessage.setMessage(message);
        errorMessage.setDetails(details);
        return errorMessage;
    }

    public static ErrorMessage unsupportedMediaType() {
        return unsupportedMediaType(ApiErrors.DEFAULT_MESSAGE_UNSUPPORTED_MEDIA_TYPE);
    }

    public static ErrorMessage unsupportedMediaType(String message) {
        return unsupportedMediaType(message, "");
    }

    public static ErrorMessage unsupportedMediaType(String message, String details) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setType(ApiErrors.TYPE_UNSUPPORTED_MEDIA_TYPE);
        errorMessage.setMessage(message);
        errorMessage.setDetails(details);
        return errorMessage;
    }

    public static ErrorMessage tooManyRequests() {
        return tooManyRequests(ApiErrors.DEFAULT_MESSAGE_TOO_MANY_REQUESTS);
    }

    public static ErrorMessage tooManyRequests(String message) {
        return tooManyRequests(message, "");
    }

    public static ErrorMessage tooManyRequests(String message, String details) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setType(ApiErrors.TYPE_TOO_MANY_REQUESTS);
        errorMessage.setMessage(message);
        errorMessage.setDetails(details);
        return errorMessage;
    }

    public static ErrorMessage serverError() {
        return serverError(ApiErrors.DEFAULT_MESSAGE_INTERNAL_SERVER_ERROR);
    }

    public static ErrorMessage serverError(String message) {
        return serverError(message, "");
    }

    public static ErrorMessage serverError(String message, String details) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setType(ApiErrors.TYPE_INTERNAL_SERVER_ERROR);
        errorMessage.setMessage(message);
        errorMessage.setDetails(details);
        return errorMessage;
    }
}
