package com.hzx.lesson.common.annotation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 日志切面类，使用 SLF4J-MDC 实现 TraceId 全链路追踪。
 * 对所有带 @RestController 注解的公共方法进行前置、环绕、后置和异常通知，
 * 并在日志中注入唯一 traceId 以及请求执行耗时。
 * 使用时需在日志框架（例如 Logback）的 pattern 中添加：
 * %X{traceId}
 * 例：<pattern>[%d{yyyy-MM-dd HH:mm:ss.SSS}] [%X{traceId}] %-5level %logger{36} - %msg%n</pattern>
 * @author zexiao.huang
 * @since 2025-05-06 13:25:38
 */
@Aspect
@Component
@Slf4j
public class LoggingAspect {

    /**
     * MDC 中存储 traceId 的 key
     */
    private static final String TRACE_ID_KEY = "traceId";
    /**
     * ThreadLocal 中存储方法开始时间，用于计算耗时
     */
    private static final ThreadLocal<Long> START_TIME = new ThreadLocal<>();

    /**
     * 切点：所有顶层 @RestController 类中的所有 public 方法
     */
    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void restController() {
    }

    /**
     * 前置通知：生成 traceId，记录请求开始时间，并打印入参和来源 IP 日志
     */
    @Before("restController()")
    public void beforeController(JoinPoint jp) {
        ServletRequestAttributes attrs =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attrs == null) {
            return;
        }

        // 1. 生成唯一 traceId，格式: 时间戳-随机8位
        String traceId = System.currentTimeMillis() + "-" + UUID.randomUUID().toString().substring(0, 8);
        // 2. 放入 MDC，后续日志自动携带
        MDC.put(TRACE_ID_KEY, traceId);
        // 3. 记录方法开始时间
        START_TIME.set(System.currentTimeMillis());

        HttpServletRequest req = attrs.getRequest();

        // 打印请求完整日志
        log.info("[{}] >>> 请求开始: {}, {} {}, 参数: {}",
                traceId,
                req.getRequestURL().toString(),
                req.getMethod(),
                req.getRequestURI(),
                jp.getArgs()
//                getRequestParams(req, jp.getArgs())
        );

    }

    /**
     * 环绕通知：执行目标方法，计算并打印耗时，最后清理上下文
     */
    @Around("restController()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        try {
            // 执行目标方法
            Object result = pjp.proceed();
            // 计算执行耗时
            long elapsed = System.currentTimeMillis() - START_TIME.get();
            String traceId = MDC.get(TRACE_ID_KEY);
            // 打印执行完成日志
            log.info("[{}] === 请求结束: 耗时：{} ms, 执行方法 {}.{}()",
                    traceId,
                    elapsed,
                    pjp.getSignature().getDeclaringType().getSimpleName(),
                    pjp.getSignature().getName()
            );
            return result;
        } finally {
            // 清理 MDC 和 ThreadLocal，防止内存泄漏
            clear();
        }
    }

    /**
     * 后置返回通知：打印响应状态码及返回结果
     */
    @AfterReturning(pointcut = "restController()", returning = "ret")
    public void afterReturning(Object ret) {
        ServletRequestAttributes attrs =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attrs == null) {
            return;
        }
        log.info("[{}] <<< 响应结果: 状态码: {}, 返回结果: {}",
                MDC.get(TRACE_ID_KEY),
                attrs.getResponse() != null ? attrs.getResponse().getStatus() : -1,
                ret
        );
    }

    /**
     * 异常通知：打印响应状态码和异常信息
     */
    @AfterThrowing(pointcut = "restController()", throwing = "ex")
    public void afterThrowing(Throwable ex) {
        ServletRequestAttributes attrs =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attrs == null) {
            return;
        }
        log.error("[{}] !!! 响应结果: 状态码: {}, 抛出异常, 异常信息: {}",
                MDC.get(TRACE_ID_KEY),
                attrs.getResponse() != null ? attrs.getResponse().getStatus() : -1,
                ex.getMessage(),
                ex
        );
    }

    /**
     * 清理 MDC 和 ThreadLocal，以免影响下一请求
     */
    private void clear() {
        MDC.remove(TRACE_ID_KEY);
        START_TIME.remove();
    }

    /**
     * 获取 HTTP 请求参数：包括 URL 参数、请求体和文件名
     * @param request HttpServletRequest 对象
     * @param args    方法入参数组
     * @return 参数字符串表示
     */
    private String getRequestParams(HttpServletRequest request, Object[] args) {
        Map<String, Object> params = new HashMap<>();
        // 查询参数
        request.getParameterMap().forEach((k, v) -> params.put(k, String.join(",", v)));
        // 请求体内容（仅 POST/PUT）
        if ("POST".equalsIgnoreCase(request.getMethod())
                || "PUT".equalsIgnoreCase(request.getMethod())) {
            try (ServletInputStream in = request.getInputStream();
                 BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
                StringBuilder body = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    body.append(line);
                }
                if (body.length() > 0) {
                    params.put("body", body.toString());
                }
            } catch (IOException e) {
                log.error("读取请求体失败", e);
            }
        }
        // MultipartFile 文件参数
        for (Object arg : args) {
            if (arg instanceof MultipartFile) {
                MultipartFile file = (MultipartFile) arg;
                params.put(file.getName(), file.getOriginalFilename());
            }
        }
        return params.toString();
    }
}
