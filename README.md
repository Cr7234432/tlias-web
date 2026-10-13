# tlias 智能学习辅助系统

> 跟着黑马程序员《JavaWeb + AI 开发》课程实现的练习项目，用于熟悉 JavaWeb 后端开发流程。学习用途，非原创。

## 项目简介

一套面向培训机构的教务管理系统，覆盖**部门、员工、班级、学员**四大核心业务的增删改查，并包含登录鉴权、操作日志、统计报表与文件上传等常见后端能力。

## 技术栈

| 组件 | 版本 / 说明 |
|---|---|
| Spring Boot | 4.0.8 |
| Spring MVC | `spring-boot-starter-webmvc` |
| MyBatis | `mybatis-spring-boot-starter` 4.0.1（XML 映射文件） |
| MySQL | `mysql-connector-j` |
| PageHelper | 1.4.7 分页插件 |
| JWT | jjwt 0.9.1（登录鉴权） |
| AOP | `spring-boot-starter-aspectj`（操作日志切面） |
| 阿里云 OSS | `aliyun-sdk-oss` 3.18.4（文件上传） |
| Lombok | 1.18.46 |
| JDK | 17（web 模块）/ 21（pojo、utils 模块） |

## 项目结构

> 注意：这不是 Maven 多模块工程，而是**三个互相独立的 Maven 项目**，通过 `SNAPSHOT` 依赖串联。

```
web-ai-project03/
├── tlias-pojo/                 实体类模块（Dept / Emp / Clazz / Student / OperateLog ...）
├── tlias-utils/                工具类模块（JWTUtils / AliyunOSSOperator / CurrentHolder）
└── Telers-web-management/      主业务模块（Spring Boot 应用入口）
```

依赖关系：`Telers-web-management` → `tlias-utils` → `tlias-pojo`

```
Telers-web-management/src/main/java/com/hairain/
├── controller/     控制层
├── service/        业务层（impl/ 为实现类）
├── mapper/         数据访问层（XML 位于 resources/com/hairain/mapper/）
├── anno/           自定义注解（@Log）
├── aspect/         AOP 切面（OperationLogAspect 操作日志）
├── interceptor/    拦截器（TokenInterceptor）
├── filter/         过滤器（TokenFilter）
├── exception/      全局异常处理
├── config/         配置类
└── utils/          工具类
```

## 功能模块

| 接口前缀 | 功能 |
|---|---|
| `/login` | 登录、颁发 JWT |
| `/depts` | 部门管理 CRUD |
| `/emps` | 员工管理（分页、条件查询、增删改、批量删除） |
| `/clazzs` | 班级管理 |
| `/students` | 学员管理 |
| `/report` | 统计报表 |
| `/log` | 操作日志分页查询 |
| 文件上传 | 基于阿里云 OSS |

其它技术点：

- `TokenInterceptor` / `TokenFilter`：JWT 登录校验
- `OperationLogAspect` + `@Log`：AOP 自动记录操作日志
- `GlobalExceptionHandler`：全局异常处理，统一返回 `Result`
- `PageHelper`：分页查询

## 本地启动

**前置条件**：JDK 17+、Maven、MySQL 8

1. 建库并导入 tlias 初始化脚本（自行准备 `tlias.sql`）

2. 复制配置模板，填入自己的信息：

   ```bash
   cp Telers-web-management/src/main/resources/application-example.yml \
      Telers-web-management/src/main/resources/application.yml
   ```

   然后修改其中的数据库账号密码与 OSS 配置。

3. **按依赖顺序安装本地模块**（没有父 pom，必须先装到本地仓库）：

   ```bash
   mvn -f tlias-pojo clean install
   mvn -f tlias-utils clean install
   ```

4. 启动主应用：

   ```bash
   mvn -f Telers-web-management spring-boot:run
   ```

   默认端口 `8080`。

## 说明

本项目为个人跟课练习，代码主要来自课程讲解，用于熟悉 JavaWeb 后端开发流程。
