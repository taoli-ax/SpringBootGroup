# SpringBootGroup
SpringBoot Learning



### bug fix

**IDEA 报错 Package 'java.util' is declared in module 'java.base', which is not in the module graph**
解决：重启idea，清除缓存  
[解决方案参考](https://blog.51cto.com/u_14301180/5575048) 

**SpringBoot报错：java.lang.IllegalStateException: Unable to find a @SpringBootConfiguration, you need to use@ContextConfiguration with your tests...**  
原因：目录路径不一致一致导致
解决：test类和java类的路径都放在同一包名路径下 xx.xx.xx.test, xx.xx.xx.dao  
[解决方案参考](https://zhuanlan.zhihu.com/p/146317623)

**vue获取到数据但无法渲染到页面**  
原因：javascript 匿名函数造成的语法问题  
问题代码：`axios.post(...).then(function(response){...})`  
解决: `axios.post(...).then(response=>{...})`  
体会：抄代码一定要谨慎，这里的response是响应  
提问： function(a){} 和a=>{}，这两个a意义一样吗：按理说一样，但实际又不一样，真是奇怪
[解决方案参考](https://bbs.csdn.net/topics/393404643)



**vue模板字符串中的@click方法无效**  
原因：模板字符串@click无法触发事件绑定  
解决：`@click`改成`onclick`, 并添加 `mounted(){ window.fun=this.fun}`
[解决方法参考](https://blog.csdn.net/weixin_40141473/article/details/118642688)
### Plugins
- spring-assistant
- springirun  

话说这两个插件的开发者真用心了，CE顿时变得香香  
[解决方案参考](https://blog.csdn.net/GLepoch/article/details/113485608)



### @profile.active@无法识别的问题
原因：application.yml中无法识别@符号引用maven的标签
解决：`pom.xml`中增加一个插件 `maven-resources-plugin`
[解决方法参考](https://blog.csdn.net/AdminPwd/article/details/96966359)
### 习惯
service层：Login(String name,String password)
dao层：selectByNameAndPassword(String name,String password)

### maven切换profile无法生效
原因：切换了<activeByDefault>标签的默认值，但运行起来仍然是以前的值
解决： 重启invalidate caches and restart 或者 重新compile一下


### swagger 配置无法生效
原因： springBoot 版本2.6以后   
解决方案：添加配置`spring.mvc.pathmatch.matching-strategy=ant_path_matcher`  
版本成功匹配： springBoot 2.7.10,swagger:2.9.2  
[解决方案连接](https://cloud.tencent.com/developer/article/2013127)

### 答疑
@RequestBody是适用于异步请求，将数据放在请求体中，格式为json



### 单体部署项目要点

- mvn package 打包项目
- 启动命名`your/path/to/bin/java -jar your/path/to/project.jar `
- 如果不跳过maven test 项目会多一些数据，如果你不介意无所谓
- 覆盖配置属性`java -jar project.jar --server.port=81`
- 禁用参数启动 `SpringApplication.run(SsmApplication.class)` ,去掉args
- 多个配置文件，springBoot会读取并集，一起奏效
- 四级配置文件对于不同的角色
  1. classpath: application.yml 开发
  2. classpath: config/application.yml 开发管理
  3. 服务器某个目录: 运维
  4. 服务器最高目录： 运维管理
- 指定配置文件名启动的参数 `--spring.config.name=application` 指定路径`--spring.config.location=classpath:/application.yml`
- 单文件配置多环境 注意使用的是`spring.profile.active.on-profile: pro`, 子环境中配置的是`spring.profile.active: pro`
- 多环境配置为多文件 名称规范 `application-dev.yml` 主配置`spring.profiles.active: dev` dev配置文件`spring.config.activate.on-profile: - dev`

**maven 作为主配置 springBoot 读取配置**
- maven标签 `<profiles></profiles>`并在`application.yml`中读取`@profile.active@`
- 注意引用插件 `maven-resource-plugin`来识别`@ @`



**@self4j**
- 加在需要日志的类上
- 自定义日志格式和颜色`logging.partten.console: "%d %clr(%5p) --- [%clr(%16t){blue}] %clr(%-40.40c){cyan} : %m %n"`
- %p 日志级别， %t线程， %clr设置颜色%， {blue}设置为蓝色， -40.40c左对齐类名占用40位并截取40位，%n换行符

### 基础功能和基础运维配置完结！

---
以下将学习更多开发类的知识

###  集成任意第三方类，使用JavaConfig @Bean来配置


### 没有文档就没有收获，一堆代码是无法直接了解做了什么的

**Mybatis 两种写法**

- annotation写法在Dao接口上@Mapper
```java
@Mapper
public interface CupDao{
   // your code here
  @Select("select count(*) from cup")
  int Count();
}
```

- 配置文件写法，除了写好接口`java.com.coh.ssm.CupDao`和Mapper对象的配置文件`resource/com/coh/ssm/CupDao.xml`，注意路径保持一致否则找不到
- 另外启动类上注解扫描`@MapperScan(basePackages = {"com.coh.ssm.dao"})`
```java

@MapperScan(basePackages = {"com.coh.ssm.dao"})
public class SsmApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsmApplication.class, args);
    }

}
```


### 热部署 IDEA CE

- 勾选在File-setting-AdvanceSetting-Allow：auto-make start even if developed app is running
- 勾选 File-setting-Compiler: Build project automatically
- `pom.xml`添加配置 `spring-boot-devtools` 插件



### banner.txt 启动字符输出配置



### Filter 配置类方式

1. 写一个配置类
```java

public class FilterDemo implements Filter {
        // implement methods
}
```
2. 用FilterRegistrationBean加载Filter配置类到spring
```java
@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<FilterDemo> RegistrationBean() {
        FilterRegistrationBean<FilterDemo> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setName("filterDemo");
        //设置其他属性，最后返回
        return registrationBean;
    }
}

```

### Interceptor配置类
1. 写一个拦截器`MyInterceptor` 完成接口`HandlerInterceptor`
2. 写一个拦截器配置类 `InterceptorConfig` 完成接口 `WebMvcConfigurer`
3. 重写方法`addInterceptors(InterceptorRegistry registry)`完成拦截路径配置

so easy



### 刚说so easy,接着就打脸的swagger配置，已经花了1天时间，但还没弄好
swagger本地访问地址：`localhost:81/swagger-ui.html`
# 见 bug fix
