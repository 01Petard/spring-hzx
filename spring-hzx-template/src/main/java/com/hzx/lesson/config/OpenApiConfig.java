package com.hzx.lesson.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpenAPI配置类
 * @author zexiao.huang
 * @since 2025-05-14 17:00:00
 */
@Configuration
public class OpenApiConfig {

    @Value("${auth.jwt.header:Authorization}")
    private String authHeader;

    @Bean
    public OpenAPI customOpenAPI() {
        final String securitySchemeName = "bearerAuth";
        
        return new OpenAPI()
                .info(new Info()
                        .title("Spring Boot 3 + JDK 21 API")
                        .description("Spring Boot 3 + JDK 21 项目模板 API 文档")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("HZX")
                                .email("example@example.com")
                                .url("https://github.com/yourusername/spring-hzx"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT")))
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
                .components(new Components()
                        .addSecuritySchemes(securitySchemeName, new SecurityScheme()
                                .name(authHeader)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")));
    }
}
