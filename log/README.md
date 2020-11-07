## springboot 日志

### 配置文件中配置

- ##### 设置相应包的日志级别为debug
logging.level.com.zyt.log:debug

- ##### 日志保存绝对路径
logging.file.path: ... 

- ##### 日志名
logging.file.name: ... 

- ##### 自定义日志配置,当配置了config 则会去读取相应的日志配置文件,放在resource文件夹中
logging.config: classpath:logback-spring.xml 
 

### 自定义配置文件 logback-spring.xml
具体查看Resource文件夹中的logback-spring.xml 配置

### 使用Lombok中简化代码
在相应的类中添加@lombok.extern.slf4j.Slf4j
则输出日志可以直接log.error(String),log.info(String)等方式调用
省掉了需要在每个类中初始化日志工厂的冗余代码

### 在拦截器中获取相应的信息并打入日志或者数据库中
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //请求日志保存
        LogEntity entity = new LogEntity();
        entity.setClientIp(request.getRemoteHost());
        entity.setServerIp(server);
        entity.setCreateBy(request.getHeader("userId"));
        entity.setHttpMethod(request.getMethod());
        entity.setPath(request.getServletPath());
        logDao.add(entity);
        //输入到日志中
        log.info("客户端IP:" + request.getRemoteHost());
        log.info("服务端IP:" + server);
        log.info("请求用户:" + request.getHeader("userId"));
        log.info("请求方法:" + request.getMethod());
        log.info("请求路径:" + request.getServletPath());
        log.info("Status:" + response.getStatus());
        return true;
    }
