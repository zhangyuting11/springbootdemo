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


### 全局异常 （后续添加）




