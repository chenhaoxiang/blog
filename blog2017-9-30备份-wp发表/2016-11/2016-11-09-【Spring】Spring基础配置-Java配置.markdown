---
layout: post
title: "【Spring】Spring基础配置-Java配置"
date: 2016-11-09 10:30:07 +0800
comments: true
categories:❷ Java大学之行,----- ⑥、框架/第三方工具,----- ----- Spring
tags: [spring,xml,java,bean]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】




分析

Java配置是Spring4.x推荐的配置方式，可以完全替代xml配置； 
Java配置也是Spring Boot推荐的配置方式。

Java配置不需要@Service声明Bean。 
也不需要@Autowired注入Bean。 
只需要通过@Configuratio 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】




分析

Java配置是Spring4.x推荐的配置方式，可以完全替代xml配置； 
Java配置也是Spring Boot推荐的配置方式。

Java配置不需要@Service声明Bean。 
也不需要@Autowired注入Bean。 
只需要通过@Configuratio
&#60;!-- more --&#62;
----------

&#60;blockquote cite='陈浩翔'&#62;
&#60;p background-color='#D3D3D3'&#62;转载请注明出处：&#60;a href='http://blog.csdn.net/qq_26525215'&#62;&#60;font color="green"&#62;http://blog.csdn.net/qq_26525215&#60;/font&#62;&#60;/a&#62;&#60;br&#62;&#60;br&#62;
本文源自&#60;strong&#62;【&#60;a href='http://blog.csdn.net/qq_26525215' target='_blank'&#62;大学之旅_谙忆的博客&#60;/a&#62;】&#60;/strong&#62;&#60;/p&#62;
&#60;/blockquote&#62;

#分析

Java配置是Spring4.x推荐的配置方式，可以完全替代xml配置；
Java配置也是Spring Boot推荐的配置方式。

Java配置不需要@Service声明Bean。
也不需要@Autowired注入Bean。
只需要通过@Configuration和@Bean来实现。

```
@configuration声明当前类是一个配置类，相当于一个Spring配置的xml文件.
@Bean注解在方法上，声明当前方法的返回值为一个Bean.
```

本篇只是演示最简单的Java配置，本【Spring】系列博客会一直更新。
要一直学下去的，可以关注我博客。

对于类的说明，我一般是写在代码注释中。

#示例:

##编写功能类的Bean
```
package cn.hncu.p1_3_2;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2016/11/4.
 * Time: 下午 10:43.
 */

//注意！ 此处没有使用@Service
public class FunctionService {
    public String sayHello(String word){
        return "Hello "+word + " !";
    }
}
```


##使用功能类的Bean

```
package cn.hncu.p1_3_2;

import cn.hncu.p1_3_1.*;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2016/11/4.
 * Time: 下午 11:10.
 */
//注意！此处没有使用@Service声明Bean
public class UseFunctionService {
    FunctionService functionService;
    //此处没有使用@Autowired注解注入Bean
    public void setFunctionService(FunctionService functionService){
        this.functionService = functionService;
    }

    public String sayHello(String word){
        return functionService.sayHello(word);
    }
}

```

##配置类

```
package cn.hncu.p1_3_2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2016/11/4.
 * Time: 下午 11:17.
 */
@Configuration
//使用@Configuration注解表明当前类是一个配置类，这意味着这个类里可能有0个或者多个@Bean注解、
//此处没有使用包扫描，是因为所有的Bean都在此类中定义了
public class JavaConfig {
    @Bean
    //使用@Bean注解声明当前方法FunctionService的返回值是一个Bean，Bean的名称是方法名
    public FunctionService functionService(){
        return new FunctionService();
    }

    /*
    @Bean
    public UseFunctionService useFunctionService(){
        UseFunctionService useFunctionService = new UseFunctionService();
        useFunctionService.setFunctionService(functionService());
        //注入FunctionService的Bean时候直接调用functionService()
        return useFunctionService;
    }
    */

    @Bean
    public  UseFunctionService useFunctionService(FunctionService functionService){
        //另外一种注入的方式，直接将FunctionService作为作为参数给useFunctionService()，这也是Spring容器提供的极好的功能。
        //在Spring容器中，只要容器中存在某个Bean，就可以在另外一个Bean的声明方法的参数中直接写入
        UseFunctionService useFunctionService = new UseFunctionService();
        useFunctionService.setFunctionService(functionService);
        return useFunctionService;
    }
}

```

##运行类

```
package cn.hncu.p1_3_2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2016/11/4.
 * Time: 下午 11:36.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);
        System.out.println(useFunctionService.sayHello("张三"));
        context.close();
    }
}

```

##运行结果

![](http://img.blog.csdn.net/20161109102250114)

项目链接-具体的包;
https://github.com/chenhaoxiang/Java/tree/master/springBoot/src/main/java/cn/hncu/p1_3_2


本文章由&#60;a href="https://chenhaoxiang.github.io/"&#62;[谙忆]&#60;/a&#62;编写， 所有权利保留。 
&#60;blockquote cite='陈浩翔'&#62;
&#60;p background-color='#D3D3D3'&#62;转载请注明出处：&#60;a href='http://blog.csdn.net/qq_26525215'&#62;&#60;font color="green"&#62;http://blog.csdn.net/qq_26525215&#60;/font&#62;&#60;/a&#62;&#60;br&#62;&#60;br&#62;
本文源自&#60;strong&#62;【&#60;a href='http://blog.csdn.net/qq_26525215' target='_blank'&#62;大学之旅_谙忆的博客&#60;/a&#62;】&#60;/strong&#62;&#60;/p&#62;
&#60;/blockquote&#62;
