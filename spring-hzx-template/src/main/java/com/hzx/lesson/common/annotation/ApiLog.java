package com.hzx.lesson.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ApiLog
 * 日志打印，使用方法：放在Controller类上
 * 作用：服务端收到该Controller类中请求中的地址后，自动将执行的方法和后续结果输出到控制台
 * @author zexiao.huang
 * @since 2025-02-28 12:55:32
 */
@Target(ElementType.TYPE) // 表示该注解可以用于类级别
@Retention(RetentionPolicy.RUNTIME) // 运行时保留，这样才能在运行时通过反射读取
public @interface ApiLog {
    String value() default "执行@ApiLog注解"; // 可以添加一些描述信息，默认为空

    boolean enabled() default true; // 是否开启日志记录，默认开启
}