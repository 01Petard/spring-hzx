package com.hzx.lesson.common.annotation;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;

/**
 * ApiLog切面类
 * @author zexiao.huang
 * @since 2025-02-28 12:59:49
 */

@Aspect // 标记为切面
@Component // 注册为Spring Bean
@Slf4j
public class ApiLogAspect {

    // 修改 @Pointcut 表达式，匹配使用了 @ApiLog 注解的类中的所有方法
    @Pointcut("@annotation(com.hzx.lesson.common.annotation.ApiLog)")
    public void ApiLogAspect() {
    }

    @Before("ApiLogAspect()")
    public void beforeApiLog(JoinPoint joinPoint) {
        // 获取目标类
        Class<?> targetClass = joinPoint.getTarget().getClass();
        // 获取 @ApiLog 注解
        ApiLog apiLog = targetClass.getAnnotation(ApiLog.class);
        if (apiLog != null && apiLog.enabled()) {
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = requestAttributes.getRequest();

            String declaringTypeName = joinPoint.getSignature().getDeclaringTypeName();
            String methodName = joinPoint.getSignature().getName();

            log.info("============ 执行方法: {}.{}() begin ============", declaringTypeName, methodName);
            // 执行时间
            String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis());
            log.info("Time          :{}", time);
            // 打印请求 URL
            log.info("URL           :{}", request.getRequestURL());
            // 打印请求 方法
            log.info("HTTP Method   :{}", request.getMethod());
            // 打印Controller 的全路径以及执行方法
            log.info("Class Method  :{}", declaringTypeName + "." + methodName);
            // 打印请求的 IP
            log.info("IP            :{}", request.getRemoteHost());
            // 打印请求入参
            log.info("Request Args  :{}", JSON.toJSONString(joinPoint.getArgs()));
            log.info("Controller方法执行中...");
        }
    }

    @After("ApiLogAspect()")
    public void afterApiLog(JoinPoint joinPoint) {
        // 获取目标类
        Class<?> targetClass = joinPoint.getTarget().getClass();
        // 获取 @ApiLog 注解
        ApiLog apiLog = targetClass.getAnnotation(ApiLog.class);
        if (apiLog != null && apiLog.enabled()) {
            String declaringTypeName = joinPoint.getSignature().getDeclaringTypeName();
            String methodName = joinPoint.getSignature().getName();
            log.info("============ 执行方法: {}.{}() end ============", declaringTypeName, methodName);
        }
    }
}