# 拦截器+异常处理

### 拦截器
#### 拦截器的作用
- 拦截非法请求,普通接口权限验证
- 记录http请求，可作为http请求记录的保存入口

#### 拦截器的使用
**1.** 新增类MyInterceptor,并实现HandlerInterceptor接口


    @Component
    public class MyInterceptor implements HandlerInterceptor
     { 
     @Override
     public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
         System.out.println("preHandle:");
      //可以获取请求信息保存到数据库
        System.out.println(request.getRequestURI());
        System.out.println(request.getMethod());
        System.out.println(response.getStatus());

        //拒绝未带token的访问
        if (request.getHeader("token") == null) {
            throw new BaseException("no access!");
        }
        return true;
     }
     
     @Override
     public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
         System.out.println("postHandle:");
     }
 
     @Override
     public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
         System.out.println("afterCompletion:");
     }
    }

**2.** 通过@Configuration 注册拦截器


    @Configuration
    public class WebConfig implements WebMvcConfigurer {
  
    @Autowired
    MyInterceptor myInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //不拦截的url
        final String[] commonExclude = {"/notInterceptor/**"};
        registry.addInterceptor(myInterceptor).excludePathPatterns(commonExclude);
     }
    }

**3.** HandlerInterceptor接口(后续补充)
- preHandle 
- postHandle
- afterCompletion

**4.** HTTP请求实现
- 正常请求时

![正常请求时](https://github.com/zhangyuting11/springbootdemo/blob/master/interceptor/document/1.jpg?raw=true)

- 拦截请求时

![拦截请求时](https://github.com/zhangyuting11/springbootdemo/blob/master/interceptor/document/2.jpg?raw=true)

- 拦截过滤时

![拦截过滤时](https://github.com/zhangyuting11/springbootdemo/blob/master/interceptor/document/3.jpg?raw=true)


### 全局异常处理 
全局异常处理可以让我们少用许多try...catch...,让代码更加简洁,把码的时间都放在业务层面上。

#### 代码实现
主要添加@ControllerAdvice注解，并在方法中定义相应的异常处理，比如程序异常，空指针异常，业务异常等等
将异常做JSON封装返回到前端。比如我们在实现拦截器的时候，在http请求未发送请求头token的时候我们就抛出了一个异常
这个时候如果不做异常捕获处理，前端是会受到500的错误页面的，出于前后端友好沟通，需要将异常封装成统一的格式给前端。
代码实现如下:

    @ControllerAdvice
    public class MyExceptionInterceptor {

    /*
    * @params : [ex]
    * @Description : //TODO 程序异常处理
    * @return : org.springframework.http.ResponseEntity
    * @Create : create by yuting 2020/11/5
    **/
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseEntity runtimeException(Exception ex) {
        return ResponseEntity.ok(BaseResult.fail("服务器异常"));
    }

    /*
    * @params : [e]
    * @Description : //TODO 业务异常全局处理
    * @return : org.springframework.http.ResponseEntity
    * @Create : create by yuting 2020/11/5
    **/
    @ResponseBody
    @ExceptionHandler(BaseException.class)
    public ResponseEntity businessException(BaseException e) {
        return ResponseEntity.ok(BaseResult.fail(e.getMessage()));
      }
    }
    





