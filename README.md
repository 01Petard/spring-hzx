# Spring Boot 3 + JDK 21 项目模板

这是一个基于Spring Boot 3和JDK 21的项目模板，提供了常用功能的基础实现。

## 项目结构

```
spring-hzx/
├── spring-hzx-template/       # 主要模块
│   ├── src/main/java/         # Java源代码
│   │   └── com/hzx/lesson/
│   │       ├── common/        # 通用工具和模型
│   │       ├── config/        # 配置类
│   │       ├── controller/    # 控制器
│   │       └── security/      # 安全相关
│   └── src/main/resources/    # 资源文件
└── pom.xml                    # 父POM文件
```

## 主要功能

- Spring Security集成与JWT认证
- Redis缓存支持
- MyBatis Plus ORM框架
- SpringDoc OpenAPI文档
- 全局异常处理
- 统一响应格式

## 技术栈

- JDK 21
- Spring Boot 3.2.0
- Spring Security
- MyBatis Plus 3.5.3
- Redis
- MySQL 8
- JWT 0.11.5
- Hutool 5.8.11

## 快速开始

1. 克隆项目
```bash
git clone https://github.com/yourusername/spring-hzx.git
```

2. 配置数据库
编辑`application.yml`文件，设置数据库连接信息。

3. 运行项目
```bash
mvn spring-boot:run
```

4. 访问API文档
```
http://localhost:18099/swagger-ui/index.html
```

## 升级指南

如果您正在将旧项目升级到Spring Boot 3和JDK 21，请参考[升级指南](spring-hzx-template/src/main/resources/AmazonQ.md)。
