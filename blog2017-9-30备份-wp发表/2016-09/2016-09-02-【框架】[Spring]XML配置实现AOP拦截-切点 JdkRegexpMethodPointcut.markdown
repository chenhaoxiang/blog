---
layout: post
title: "【框架】[Spring]XML配置实现AOP拦截-切点 JdkRegexpMethodPointcut"
date: 2016-09-02 11:47:06 +0800
comments: true
categories:❷ Java大学之行,----- ⑥、框架/第三方工具,----- ----- Spring
tags: [spring,xml,框架,aop]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
如果你把此种纯Java方式实现AOP拦截读懂了，理解本篇博客会更容易。 
【框架】[Spring]纯Java的方式实现AOP切面(拦截)技术 这篇讲解的是用xml配置文件来实现AOP拦截。 
其实也挺简单的，无非是把一些对象通过xml文件配置new出来与初始化里面的一些值。需要的包什么 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
如果你把此种纯Java方式实现AOP拦截读懂了，理解本篇博客会更容易。 
【框架】[Spring]纯Java的方式实现AOP切面(拦截)技术 这篇讲解的是用xml配置文件来实现AOP拦截。 
其实也挺简单的，无非是把一些对象通过xml文件配置new出来与初始化里面的一些值。需要的包什么
&#60;!-- more --&#62;
----------

&#60;blockquote cite='陈浩翔'&#62;
&#60;p background-color='#D3D3D3'&#62;转载请注明出处：&#60;a href='http://blog.csdn.net/qq_26525215'&#62;&#60;font color="green"&#62;http://blog.csdn.net/qq_26525215&#60;/font&#62;&#60;/a&#62;&#60;br&#62;&#60;br&#62;
本文源自&#60;strong&#62;【&#60;a href='http://blog.csdn.net/qq_26525215' target='_blank'&#62;大学之旅_谙忆的博客&#60;/a&#62;】&#60;/strong&#62;&#60;/p&#62;
&#60;/blockquote&#62;

如果你把此种纯Java方式实现AOP拦截读懂了，理解本篇博客会更容易。
&#60;a href="http://blog.csdn.net/qq_26525215/article/details/52400791"&#62;【框架】[Spring]纯Java的方式实现AOP切面(拦截)技术 &#60;/a&#62;

这篇讲解的是用xml配置文件来实现AOP拦截。
其实也挺简单的，无非是把一些对象通过xml文件配置new出来与初始化里面的一些值。

需要的包什么的就不解释了，直接给个网址：
http://repo.springsource.org/libs-release-local/org/springframework/spring/


#项目结构图

![](http://img.blog.csdn.net/20160902114123990)


直接上代码
#1、准备好原型对象：

```
package cn.hncu.xmlImpl;

public class Person {
	public void run(){
		System.out.println("我在run...");
	}
	
	public void run(int i){
		System.out.println("我在run"+i+"...");
	}
	
	public void say(){
		System.out.println("我在say...");
	}
	
}
```


#2、准备好代理类

代理动作什么的都会写在这里，为了方便，只实现MethodInterceptor接口，里面的invoke是最强的。

```
package cn.hncu.xmlImpl;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundAdvice implements MethodInterceptor{
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("前面拦截....");
		Object resObj = invocation.proceed();//放行
		System.out.println("后面拦截.....");
		return resObj;
	}

}

```

#3、配置好xml文件：

##把切点和通知配置成 切面的外部bean
取名为:1.xml

```
&#60;?xml version="1.0" encoding="UTF-8"?&#62;
&#60;beans xmlns="http://www.springframework.org/schema/beans"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xmlns:context="http://www.springframework.org/schema/context"
		xmlns:tx="http://www.springframework.org/schema/tx"
		xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-4.3.xsd
				http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.3.xsd
				http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-4.3.xsd"&#62;
	
	&#60;!-- 代理前原对象 --&#62;
	&#60;bean id="person" class="cn.hncu.xmlImpl.Person"&#62;&#60;/bean&#62;
	
	&#60;!-- 切点 --&#62;
	&#60;bean id="cut" class="org.springframework.aop.support.JdkRegexpMethodPointcut"&#62;
		&#60;property name="pattern" value=".*run.*"&#62;&#60;/property&#62;
	&#60;/bean&#62;
	
	&#60;!-- 通知-由我们写，实际代理动作 --&#62;
	&#60;bean id="advice" class="cn.hncu.xmlImpl.AroundAdvice"&#62;&#60;/bean&#62;
	
	&#60;!-- 切面 = 切点+通知 --&#62;
	&#60;bean id="advisor" class="org.springframework.aop.support.DefaultPointcutAdvisor"&#62;
		&#60;property name="pointcut" ref="cut"&#62;&#60;/property&#62;
		&#60;property name="advice" ref="advice"&#62;&#60;/property&#62;
	&#60;/bean&#62;
	
	&#60;!-- 代理工厂 --&#62;
	&#60;bean id="personProxied" class="org.springframework.aop.framework.ProxyFactoryBean"&#62;
		&#60;!-- 放入原型对象 --&#62;
		&#60;property name="target" ref="person"&#62;&#60;/property&#62;
		
		&#60;!-- 放入切面 --&#62;
		&#60;property name="interceptorNames"&#62;
			&#60;list&#62;
				&#60;value&#62;advisor&#60;/value&#62;
			&#60;/list&#62;
		&#60;/property&#62;
	&#60;/bean&#62;
	
	
&#60;/beans&#62;
```

##把切点和通知配置成 切面的内部bean

```
&#60;beans ..&#62;
&#60;!-- 代理前原对象 --&#62;
	&#60;bean id="person" class="cn.hncu.xmlImpl.Person"&#62;&#60;/bean&#62;

	&#60;!-- 切面 = 切点+通知 --&#62;
	&#60;bean id="advisor" class="org.springframework.aop.support.DefaultPointcutAdvisor"&#62;
		&#60;!-- 切点 --&#62;
		&#60;property name="pointcut"&#62;
			&#60;bean class="org.springframework.aop.support.JdkRegexpMethodPointcut"&#62;
				&#60;property name="pattern" value=".*run.*"&#62;&#60;/property&#62;
			&#60;/bean&#62;
		&#60;/property&#62;
		&#60;!-- 通知-由我们写，实际代理动作 --&#62;
		&#60;property name="advice"&#62;
			&#60;bean id="advice" class="cn.hncu.xmlImpl.AroundAdvice"&#62;&#60;/bean&#62;
		&#60;/property&#62;
	&#60;/bean&#62;

	&#60;!-- 代理工厂 --&#62;
	&#60;bean id="personProxied" class="org.springframework.aop.framework.ProxyFactoryBean"&#62;
		&#60;!-- 放入原型对象 --&#62;
		&#60;property name="target" ref="person"&#62;&#60;/property&#62;

		&#60;!-- 放入切面 --&#62;
		&#60;property name="interceptorNames"&#62;
			&#60;list&#62;
				&#60;value&#62;advisor&#60;/value&#62;
			&#60;/list&#62;
		&#60;/property&#62;
	&#60;/bean&#62;
&#60;/beans&#62;
```

##直接在切面bean中配置“切点的正则表达式”，省去“切点bean”的配置

```
&#60;beans...&#62;
&#60;?xml version="1.0" encoding="UTF-8"?&#62;
&#60;beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:context="http://www.springframework.org/schema/context"
	xmlns:tx="http://www.springframework.org/schema/tx"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-4.3.xsd
				http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.3.xsd
				http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-4.3.xsd"&#62;

	&#60;!-- 代理前原对象 --&#62;
	&#60;bean id="person" class="cn.hncu.xmlImpl.Person"&#62;&#60;/bean&#62;

	&#60;!-- 切面 = 切点+通知 --&#62;
	&#60;bean id="advisor" class="org.springframework.aop.support.RegexpMethodPointcutAdvisor"&#62;
		&#60;!-- 切点 --&#62;
		&#60;property name="patterns"&#62;
			&#60;list&#62;
	  	 		&#60;value&#62;.*run.*&#60;/value&#62;
	  		&#60;/list&#62;
		&#60;/property&#62;
		&#60;!-- 通知-由我们写，实际代理动作 --&#62;
		&#60;property name="advice"&#62;
			&#60;bean id="advice" class="cn.hncu.xmlImpl.AroundAdvice"&#62;&#60;/bean&#62;
		&#60;/property&#62;
	&#60;/bean&#62;

	&#60;!-- 代理工厂 --&#62;
	&#60;bean id="personProxied" class="org.springframework.aop.framework.ProxyFactoryBean"&#62;
		&#60;!-- 放入原型对象 --&#62;
		&#60;property name="target" ref="person"&#62;&#60;/property&#62;

		&#60;!-- 放入切面 --&#62;
		&#60;property name="interceptorNames"&#62;
			&#60;list&#62;
				&#60;value&#62;advisor&#60;/value&#62;
			&#60;/list&#62;
		&#60;/property&#62;
	&#60;/bean&#62;


&#60;/beans&#62;
&#60;/beans&#62;
```

#4、测试方法：

```
@Test//把切点和通知配置成 切面的外部bean
	public void demo1(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("cn/hncu/xmlImpl/1.xml");
		Person p =ctx.getBean("personProxied",Person.class);
		p.run();
		p.say();
	}
	
	@Test//把切点和通知配置成 切面的内部bean
	public void demo2(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("cn/hncu/xmlImpl/2.xml");
		Person p =ctx.getBean("personProxied",Person.class);
		p.run();
		p.say();
	}
	
	@Test//直接在切面bean中配置“切点的正则表达式”，省去“切点bean”的配置
	public void demo3(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("cn/hncu/xmlImpl/3.xml");
		Person p =ctx.getBean("personProxied",Person.class);
		p.run();
		p.say();
	}
```

#输出结果：

![](http://img.blog.csdn.net/20160902114027067)

这是通过定义JdkRegexpMethodPointcut切入点的方式来实现AOP，通过这种编程方式，可以针对业务方法进行包装或者监控。

但是这个JdkRegexpMethodPointcut还不是很好，它拦截的单位是类！而无法细分到方法。不过放心，后面还有3中切点技术~
用AspectJExpressionPointcut切点就可以实现专门对什么方法进行拦截。后面会有专门介绍与实例的。



本文章由&#60;a href="http://blog.csdn.net/qq_26525215"&#62;[谙忆]&#60;/a&#62;编写， 所有权利保留。 
&#60;blockquote cite='陈浩翔'&#62;
&#60;p background-color='#D3D3D3'&#62;转载请注明出处：&#60;a href='http://blog.csdn.net/qq_26525215'&#62;&#60;font color="green"&#62;http://blog.csdn.net/qq_26525215&#60;/font&#62;&#60;/a&#62;&#60;br&#62;&#60;br&#62;
本文源自&#60;strong&#62;【&#60;a href='http://blog.csdn.net/qq_26525215' target='_blank'&#62;大学之旅_谙忆的博客&#60;/a&#62;】&#60;/strong&#62;&#60;/p&#62;
&#60;/blockquote&#62;
