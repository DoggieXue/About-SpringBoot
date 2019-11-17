# About-SpringBoot
SpringBoot学习相关  
- SpringBoot版本Hello World
- SpringBoot实现对数据库表的增删改查
- SpringBoot使用AOP对HTTP请求进行日志记录  
    PS：AOP只对public和protected方法起作用，因此，被切Controller类中定义的方法不应该出现private，否则会导致Controller中注入的service为null
 
- SpringBoot表单验证  
    使用@Valid和BindingResult实现
- 使用maven-assembly-plugin插件对SpringBoot项目打增量包