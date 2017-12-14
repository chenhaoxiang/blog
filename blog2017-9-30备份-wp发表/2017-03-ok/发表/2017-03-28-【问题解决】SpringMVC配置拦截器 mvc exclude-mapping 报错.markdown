---
layout: post
title: "【问题解决】SpringMVC配置拦截器 mvc exclude-mapping 报错"
date: 2017-03-28 03:31:45 +0800
comments: true
categories:❻ 其他,----- 上网技巧/问题解决
tags: [spring mvc,mvc]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
今天写SpringMVC的拦截器的时候，遇到这样一个错误， 
 
Element mvc:exclude-mapping is not allowed here.    <!-- SpringMVC拦截器 -->
    <mvc:interceptors>
        <mvc: 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
今天写SpringMVC的拦截器的时候，遇到这样一个错误， 
 
Element mvc:exclude-mapping is not allowed here.    &#60;!-- SpringMVC拦截器 --&#62;
    &#60;mvc:interceptors&#62;
        &#60;mvc:
&#60;!-- more --&#62;
----------


今天写SpringMVC的拦截器的时候，遇到这样一个错误，
![](http://img.blog.csdn.net/20170328032724585?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
Element mvc:exclude-mapping is not allowed here.

```xml
    &#60;!-- SpringMVC拦截器 --&#62;
    &#60;mvc:interceptors&#62;
        &#60;mvc:interceptor&#62;
            &#60;mvc:mapping path="/user/*"/&#62; &#60;!-- 拦截范围 --&#62;
            &#60;mvc:exclude-mapping path="/user/login.*"/&#62; &#60;!--不被拦截范围（路径）--&#62;
            &#60;bean class="com.uifuture.interceptor.UserLoginInterceptor"&#62;&#60;/bean&#62;
        &#60;/mvc:interceptor&#62;
    &#60;/mvc:interceptors&#62;


```

经过一番搜索，找到了原因。

SpringMVC在3.2版本之前是不支持mvc:exclude-mapping 标签的。

可以将把
http://www.springframework.org/schema/mvc/spring-mvc-3.0.xsd
改成
http://www.springframework.org/schema/mvc/spring-mvc-3.2.xsd

这样问题可以得到解决。

![](http://img.blog.csdn.net/20170328033103089?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

