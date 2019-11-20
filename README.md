# About-SpringBoot

SpringBoot引入Filter实现对URL的权限控制
---

# 方式一：注解的方式添加Filter

- 自定义一个类实现javax.servlet.Filter接口
- 给该类添加@WebFilter注解
- 启动类中额外添加@ServletComponentScan注解
- @WebFilter中urlPatterns匹配的内容不包含server.context-path的值

```$xslt
2019-11-19 16:18:56,287 [localhost-startStop-1] INFO  o.s.boot.web.servlet.FilterRegistrationBean:271 - Mapping filter: 'myFilter' to urls: [/areas/*]
2019-11-19 16:18:56,302 [localhost-startStop-1] INFO  com.cloud.xue.demo.Filter.AnnotationFilter:31 - init method in Filter is invoked !
2019-11-19 16:18:56,303 [localhost-startStop-1] INFO  com.cloud.xue.demo.Filter.AnnotationFilter:33 - 初始化参数值是=paramValue
``` 

若在自定义Filter中再引入@Component注解，会导致自定义Filter会初始化两次，名字分别为'myFilter'和'annotationFilter'，过滤的url会包括默认的`/*`，导致自定义的过滤器失效。
```$xslt
2019-11-19 15:59:24,634 [localhost-startStop-1] INFO  o.s.boot.web.servlet.FilterRegistrationBean:271 - Mapping filter: 'myFilter' to urls: [/areas/*]
2019-11-19 15:59:24,635 [localhost-startStop-1] INFO  o.s.boot.web.servlet.FilterRegistrationBean:258 - Mapping filter: 'annotationFilter' to: [/*]
2019-11-19 15:59:24,649 [localhost-startStop-1] INFO  com.cloud.xue.demo.Filter.AnnotationFilter:31 - init method in Filter is invoked !
2019-11-19 15:59:24,650 [localhost-startStop-1] INFO  com.cloud.xue.demo.Filter.AnnotationFilter:33 - 初始化参数值是=null
2019-11-19 15:59:24,650 [localhost-startStop-1] INFO  com.cloud.xue.demo.Filter.AnnotationFilter:31 - init method in Filter is invoked !
2019-11-19 15:59:24,650 [localhost-startStop-1] INFO  com.cloud.xue.demo.Filter.AnnotationFilter:33 - 初始化参数值是=paramValue
```

# 方式二：代码注册方式添加Filter
在启动类中使用`FilterRegistrationBean`添加
```$xslt
2019-11-20 12:59:12,398 [localhost-startStop-1] INFO  o.s.boot.web.servlet.FilterRegistrationBean:271 - Mapping filter: 'myFilter' to urls: [/areas/*]
2019-11-20 12:59:12,398 [localhost-startStop-1] INFO  o.s.boot.web.servlet.ServletRegistrationBean:190 - Mapping servlet: 'dispatcherServlet' to [/]
2019-11-20 12:59:12,413 [localhost-startStop-1] INFO  com.cloud.xue.demo.Filter.RegisterByCodeFilter:23 - init method in Filter is invoked !
2019-11-20 12:59:12,413 [localhost-startStop-1] INFO  com.cloud.xue.demo.Filter.RegisterByCodeFilter:25 - 初始化参数值是=paramValues
```
...

SpringBoot学习相关  
---
- SpringBoot版本Hello World
- SpringBoot实现对数据库表的增删改查
- SpringBoot使用AOP对HTTP请求进行日志记录  
    PS：AOP只对public和protected方法起作用，因此，被切Controller类中定义的方法不应该出现private，否则会导致Controller中注入的service为null
 
- SpringBoot表单验证  
    使用@Valid和BindingResult实现
- 使用maven-assembly-plugin插件对SpringBoot项目打增量包  