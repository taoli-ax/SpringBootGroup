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


### 习惯
service层：Login(String name,String password)
dao层：selectByNameAndPassword(String name,String password)


### 答疑
@RequestBody是适用于异步请求，将数据放在请求体中，格式为json