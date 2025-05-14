package com.hzx.lesson.common.exception;

/**
 * 通用错误枚举
 * @author zexiao.huang
 * @since 2025-05-06 16:20:49
 */
public enum BadRequestError {

    // ========== 认证 & 登录 ==========
    PASSWORD_ERROR             (1001, "密码错误"),
    MESSAGE_ERROR              (1002, "验证码错误"),
    ACCOUNT_NOT_FOUND          (1003, "账号不存在"),
    ACCOUNT_LOCKED             (1004, "账号被锁定"),
    ALREADY_EXISTS             (1005, "已存在"),
    UNKNOWN_ERROR              (1006, "未知错误"),
    USER_NOT_LOGIN             (1007, "用户未登录"),
    PASSWORD_EDIT_FAILED       (1008, "密码修改失败"),

    // ========== 用户 & 注册 ==========
    USER_NOT_EXIST             (2001, "用户不存在"),
    USER_ALREADY_EXIST         (2002, "用户名已存在"),
    USER_NO_ORDERS             (2003, "用户无点餐历史记录"),
    REGISTER_FAILED            (2004, "注册失败"),
    LOGIN_FAILED               (2005, "登录失败"),

    // ========== 文件上传 ==========
    UPLOAD_FAILED              (3001, "文件上传失败"),

    // ========== 中间件 ==========
    REDIS_ERROR                (4001, "Redis 操作异常"),
    REDIS_EMPTY_KEY            (4002, "Redis 中不存在指定 Key"),

    // ========== CRUD 通用 ==========
    INVALID_PARAMS             (5001, "请求参数校验失败"),
    ENTITY_NOT_FOUND           (5002, "资源不存在或已被删除"),
    CREATE_FAILED              (5003, "新增操作失败"),
    UPDATE_FAILED              (5004, "更新操作失败"),
    DELETE_FAILED              (5005, "删除操作失败"),
    BATCH_DELETE_FAILED        (5006, "批量删除操作失败"),
    QUERY_FAILED               (5007, "查询操作失败"),
    DUPLICATE_KEY              (5008, "数据已存在，违反唯一约束"),
    OPERATION_NOT_ALLOWED      (5009, "该操作不被允许"),

    // ========== 其他业务 ==========

    ;

    /** 业务错误码，方便前端定位问题 */
    private final int code;
    /** 默认错误消息 */
    private final String message;

    BadRequestError(int code, String message) {
        this.code = code;
        this.message = message;
    }
    public int getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
