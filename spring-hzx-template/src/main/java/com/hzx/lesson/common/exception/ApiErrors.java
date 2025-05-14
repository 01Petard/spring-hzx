package com.hzx.lesson.common.exception;

import lombok.experimental.UtilityClass;

/**
 * @author shenzh
 */
@UtilityClass
public class ApiErrors {

    public static final String TYPE_UNAUTHORIZED = "access_denied";
    public static final String DEFAULT_MESSAGE_UNAUTHORIZED = "未认证";
    public static final String DEFAULT_MESSAGE_CODE_UNAUTHORIZED = "error.401";

    public static final String TYPE_BAD_REQUEST = "invalid_request";
    public static final String DEFAULT_MESSAGE_BAD_REQUEST = "请求参数有误";
    public static final String DEFAULT_MESSAGE_CODE_BAD_REQUEST = "error.400";

    public static final String TYPE_FORBIDDEN = "forbidden";
    public static final String DEFAULT_MESSAGE_FORBIDDEN = "你无权执行此操作";
    public static final String DEFAULT_MESSAGE_CODE_FORBIDDEN = "error.403";

    public static final String TYPE_NOT_FOUND = "not_found";
    public static final String DEFAULT_MESSAGE_NOT_FOUND = "该内容不存在";
    public static final String DEFAULT_MESSAGE_CODE_NOT_FOUND = "error.404";

    public static final String TYPE_METHOD_NOT_ALLOWED = "method_not_allowed";
    public static final String DEFAULT_MESSAGE_METHOD_NOT_ALLOWED = "method not allowed";

    public static final String TYPE_UNSUPPORTED_MEDIA_TYPE = "unsupported_media_type";
    public static final String DEFAULT_MESSAGE_UNSUPPORTED_MEDIA_TYPE = "Unsupported Media Type";

    public static final String TYPE_TOO_MANY_REQUESTS = "too_many_requests";
    public static final String DEFAULT_MESSAGE_TOO_MANY_REQUESTS = "Too Many Requests";

    public static final String TYPE_INTERNAL_SERVER_ERROR = "server_error";
    public static final String DEFAULT_MESSAGE_INTERNAL_SERVER_ERROR = "服务器出错";
    public static final String DEFAULT_MESSAGE_CODE_INTERNAL_SERVER_ERROR = "error.500";

    public static final String TYPE_NETWORK_ERROR = "network_error";
    public static final String DEFAULT_MESSAGE_TYPE_NETWORK_ERROR = "内部网络请求出错";
    public static final String DEFAULT_MESSAGE_CODE_TYPE_NETWORK_ERROR = "error.506";
}
