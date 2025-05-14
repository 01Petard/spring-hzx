package com.hzx.lesson.config;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * OkHttp客户端配置
 * @author shenzh
 * @updated for Spring Boot 3 and JDK 21
 */
@Configuration
public class OkHttpClientConfig {

    @Bean
    public OkHttpClient okHttpClient() {
        // 配置日志拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        // 使用JDK 21的虚拟线程池
        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();

        // 配置连接池
        ConnectionPool connectionPool = new ConnectionPool(10, 5, TimeUnit.MINUTES);

        return new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .connectionPool(connectionPool)
                .dispatcher(new okhttp3.Dispatcher(executorService))
                .build();
    }
}
