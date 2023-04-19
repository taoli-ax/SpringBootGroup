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



### Plugins
- spring-assistant
- springirun  

话说这两个插件的开发者真用心了，CE顿时变得香香  
[解决方案参考](https://blog.csdn.net/GLepoch/article/details/113485608)