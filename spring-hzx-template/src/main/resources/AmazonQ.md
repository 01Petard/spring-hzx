# Spring Boot 3 + JDK 21 升级指南

本文档记录了将项目从Spring Boot 2 + JDK 8升级到Spring Boot 3 + JDK 21的主要变更。

## 主要变更

1. **Security配置更新**
   - 移除了已弃用的`WebSecurityConfigurerAdapter`
   - 使用`SecurityFilterChain` Bean替代`configure(HttpSecurity)`方法
   - 使用`@EnableMethodSecurity`替代`@EnableGlobalMethodSecurity`

2. **Servlet API包变更**
   - 从`javax.servlet`迁移到`jakarta.servlet`
   - 所有相关类的导入都需要更新

3. **JWT过滤器更新**
   - 从`BasicAuthenticationFilter`迁移到`OncePerRequestFilter`
   - 使用构造函数注入替代`@Autowired`字段注入

4. **Swagger/API文档更新**
   - 从Springfox迁移到SpringDoc OpenAPI
   - 更新了API路径和配置方式
   - 更新Swagger注解：
     - `@Api` → `@Tag`
     - `@ApiOperation` → `@Operation`
     - `@ApiModelProperty` → `@Schema`

5. **依赖更新**
   - MySQL连接器从`mysql-connector-java`更新到`mysql-connector-j`
   - 启用了SpringDoc OpenAPI依赖

## 代码示例

### Security配置更新

```java
// 旧代码
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 配置
    }
}

// 新代码
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .cors(cors -> cors.configure(http))
            .csrf(csrf -> csrf.disable())
            // 其他配置
            ;
        return http.build();
    }
}
```

### Servlet API包变更

```java
// 旧代码
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 新代码
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
```

### JWT过滤器更新

```java
// 旧代码
public class JwtAuthenticationFilter extends BasicAuthenticationFilter {
    @Autowired
    private JwtUtils jwtUtils;
    
    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }
}

// 新代码
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtUtils jwtUtils;
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 实现
    }
}
```

### Swagger/API文档更新

```java
// 旧代码 - 配置类
@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfiguration {
    @Bean
    public Docket createRestApi() {
        // 配置
    }
}

// 新代码 - 配置类
@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API标题")
                        .description("API描述")
                        .version("1.0"));
    }
}

// 旧代码 - 控制器
@Api(tags = "用户管理")
public class UserController {
    @ApiOperation("用户登录")
    public ResponseEntity<ApiResponse<LoginShowVo>> userLogin() {
        // 实现
    }
}

// 新代码 - 控制器
@Tag(name = "用户管理", description = "用户相关接口")
public class UserController {
    @Operation(summary = "用户登录", description = "用户登录接口")
    public ResponseEntity<ApiResponse<LoginShowVo>> userLogin() {
        // 实现
    }
}

// 旧代码 - 模型
public class UserLoginDto {
    @ApiModelProperty(value = "用户账号")
    private String username;
}

// 新代码 - 模型
@Schema(description = "用户登录DTO")
public class UserLoginDto {
    @Schema(description = "用户账号", requiredMode = Schema.RequiredMode.REQUIRED)
    private String username;
}
```

## 依赖更新

```xml
<!-- 旧依赖 -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>${mysql.connector.version}</version>
</dependency>

<!-- 新依赖 -->
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>${mysql.connector.version}</version>
</dependency>

<!-- API文档 -->
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>${springdoc.version}</version>
</dependency>
```

## 注意事项

1. 确保所有使用`javax.servlet`的类都更新为`jakarta.servlet`
2. 检查所有使用Spring Security的地方，特别是自定义过滤器和处理器
3. 更新Swagger注解和配置
4. 检查数据库连接和ORM相关配置
5. 利用JDK 21的新特性，如记录模式、密封类等
